package com.stubs.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import com.stubs.app.model.mps.LookUpResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stubs.app.model.mcsend.PaymentResponse;
import com.stubs.app.model.mcsend.SearchResponse;
import com.stubs.app.model.mcsend.TransferEligibilityResponse;
import com.stubs.app.model.mcsend.TransferEligibleRequest;


@Service
public class McSendService {
	
	private static String paymentsJson = "{\"payments\":{\"itemCount\":1,\"resourceType\":\"list\",\"data\":{\"payment\":[{\"paymentReference\":\"pay_789378\",\"paymentId\":\"pid_1248596\",\"transactionStatus\":\"APPROVED\",\"transactionStatusReason\":\"Card Declined\",\"originalTransactionstatus\":\"APPROVED\",\"transmissionDateTime\":\"2019-06-17T18:05:02Z\",\"networkResponseCode\":\"56\",\"switchSerialNumber\":\"157105207\",\"systemTraceAuditNumber\":\"123456\",\"retrievalRequestNumber\":\"123456\",\"authorizationCode\":\"E75A5E\",\"fundsAvailability\":\"IMMEDIATE\",\"tokenRequestorId\":\"ABC123456\",\"uniqueTransactionReference\":\"1234567890\",\"settlementAmount\":1000,\"settlementCurrency\":\"USD\",\"paymentAccountReference\":\"1234BE0F9E2464BE28FADBE009AB4\",\"transactionLocalDateTime\":\"2019-06-17T18:05:02Z\",\"paymentType\":\"P2P\",\"merchantCategoryCode\":\"6536\",\"transferAcceptor\":{\"address\":{\"city\":\"ofallon\",\"country\":\"USA\",\"postalCode\":\"6171111111\",\"state\":\"MO\",\"street\":\"2200 Mastercard Blvd\"},\"convenienceAmount\":\"333\",\"convenienceIndicator\":\"01\",\"id\":\"456487898368\",\"mastercardAssignedMerchantId\":\"12A346\",\"name\":\"transferacceptor\",\"paymentFacilitatorId\":\"123\",\"subMerchantId\":\"223\",\"terminalId\":\"1367-hgf\"},\"acquiringCredentials\":{\"acquiringCountry\":\"USA\",\"acquiringIca\":\"1234\",\"dualMessage\":{\"acquiringBin\":\"123456\"},\"singleMessage\":{\"acquiringIdentificationCode\":\"123456\",\"processorId\":\"9000123456\"}},\"sender\":{\"accountUri\":\"pan:5111222233334444;exp=2020-10;cvc=123;ucaf=ABC;cavv=123;cryptogramType=DSRP_CHIP;cryptogramValue=341341341;panSequenceNumber=01\",\"address\":{\"city\":\"ofallon\",\"country\":\"USA\",\"postalCode\":\"6171111111\",\"state\":\"MO\",\"street\":\"2200 Mastercard Blvd\"},\"countryOfBirth\":\"USA\",\"dateOfBirth\":\"1981-03-27\",\"digitalAccountReferenceNumber\":\"pan:5432123456789012;exp=2050-02;cvc=123\",\"email\":\"jane.doe@mastercard.com\",\"governmentIdUris\":[\"dln:NHL12506717;expiration-date=2022-01-02;issue-date=2017-01-11;issuing-country=USA;issuing-place=New Hampshire\"],\"name\":\"Smith Jane\",\"nationality\":\"USA\",\"phone\":\"1234567890\"},\"recipient\":{\"accountUri\":\"pan:5111222233334444;exp=2020-10;cvc=123;ucaf=ABC;cavv=123;cryptogramType=DSRP_CHIP;cryptogramValue=341341341;panSequenceNumber=01\",\"address\":{\"city\":\"ofallon\",\"country\":\"USA\",\"postalCode\":\"6171111111\",\"state\":\"MO\",\"street\":\"2200 Mastercard Blvd\"},\"countryOfBirth\":\"USA\",\"dateOfBirth\":\"1981-03-27\",\"digitalAccountReferenceNumber\":\"pan:5432123456789012;exp=2050-02;cvc=123\",\"email\":\"jane.doe@mastercard.com\",\"governmentIdUris\":[\"dln:NHL12506717;expiration-date=2022-01-02;issue-date=2017-01-11;issuing-country=USA;issuing-place=New Hampshire\"],\"name\":\"Smith Jane\",\"nationality\":\"USA\",\"phone\":\"1234567890\"},\"fundingSource\":\"CREDIT\",\"amount\":6000,\"currency\":\"USD\",\"additionalMessage\":\"Adding additional message\",\"qrData\":\"12\",\"participationId\":\"1234567890\",\"transactionPurpose\":\"07\",\"deviceType\":\"WEB\",\"additionalProgramData\":{\"crossNetwork\":{\"walletProviderSignature\":\"eyJraWQiOiIyM2JjYmU2NGM0YWZiZWIwNDc3MTg3YmQxNTA4MTcwODNlMjY4MGRiYzhiOTVlZmRkZTlhN2M1MTU0YjE3NjRmIiwiYWxnIjoiUlMyNTYifQ.eyJwYXJ0bmVySWQiOiJwdG5yXzFsenMwekQ2NXJvN2stT2RVWGpMV19wRmdYNCIsInBheW1lbnRSZWZlcmVuY2UiOiJyZWZfMTIzNDU2ZGQ3OTEwIiwiYW1vdW50IjoiMTAwMCIsInJlY2lwaWVudEFjY291bnRVcmkiOiJwYW46NTQzMjEyMzQ1Njc4OTAxMjtleHA9MjA5OS0xOSJ9.XO0WEr_Cwb4lYSWui6zYXms6djaQ5fSDMa1D92tHMpM5SytexZzCO9zNVxRYBKDrHsmZoMx9sAShucSaRupT4Ns7KxCykoH-bhwQW7HeoMQbF4kDbRbgAgrajYD3m7_uMWoI4EG51ugcq7UfhQCObig6GEiSGQ6eiavyzdzKQWN-gt4_iPWur9TITX2NJpDQwde2HOB3pgpuC55coWZnmQNePceLDVfj85_ukkrGA4pbXze0pnOgshshQS9Xe6_dk4BmTDH2MNcRf67odqXmnRGIplumA81oBiCWyaDIc6cqUlIOoMVZKWvZCvynTtAloNb18vV2OetBE2a5Mfhkbg\"}}}]}}}";
	
	public PaymentResponse getResponse(String partner_id){
        ObjectMapper mapper = new ObjectMapper();
        PaymentResponse response = null;
        try {
        	//for dev
        	//String resource = "./MCSendPayments.xlsx";

			//For Dev MC
			String resource = "/fs01/app/stubs-xml/MCSendPayments.xlsx";

			//For QA
			//String resource = "/var/tmp/MCSendPayments.xlsx";
			response = getResponseDetails(partner_id, mapper, response, resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
	
	public SearchResponse getSearchResponse(String partner_id){
		System.out.println("Search partner_id: "+ partner_id );
        ObjectMapper mapper = new ObjectMapper();
        SearchResponse response = null;
        try {
            response =  mapper.readValue(paymentsJson, SearchResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
	
	public TransferEligibilityResponse getTrEligibleResponse(String partner_id) {
		ObjectMapper mapper = new ObjectMapper();
		TransferEligibilityResponse response = null;
		try {
			//for dev
			//String resource = "./MCSendingEligibility.xlsx";

			//For Dev MC
			String resource = "/fs01/app/stubs-xml/MCSendingEligibility.xlsx";

			//For QA
			//String resource = "/var/tmp/MCSendingEligibility.xlsx";
			response = getTrEligibleResponseDetails(partner_id, mapper,resource);
		}catch (Exception e){
			e.printStackTrace();
		}
		return response;
	}

	
	@SuppressWarnings("resource")
	private PaymentResponse getResponseDetails(String partner_id, ObjectMapper mapper, PaymentResponse response,
			String resource) throws JsonParseException, JsonMappingException, IOException {
		
		File file = Paths.get(resource).toFile();
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {
			Row row = itr.next();
			for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
				if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(partner_id)) {
					row = sheet.getRow(rn);
					break;
				}
			}
			Iterator<Cell> cellIterator = row.cellIterator();
			ArrayList<String> aL = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					aL.add(String.valueOf(cell.getNumericCellValue()));
				}
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					aL.add(cell.getStringCellValue());
				}
			}
			String jsonStr = aL.get(2).toString();
			aL.stream().forEach(System.out::println);
			mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			response = mapper.readValue(jsonStr, PaymentResponse.class);
			response.setStatusCode(""+Double.valueOf(aL.get(1)).intValue());
			break;
		}
		return response;
	}
	
	@SuppressWarnings("resource")
	private TransferEligibilityResponse getTrEligibleResponseDetails(String partner_id, ObjectMapper mapper,
														   String resource) {
		TransferEligibilityResponse response = null;
		try {
			File file = Paths.get(resource).toFile();
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
					Cell cell = sheet.getRow(rn).getCell(0);
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().
								equalsIgnoreCase(partner_id)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().
								equalsIgnoreCase(partner_id)) {
							row = sheet.getRow(rn);
							break;
						}
					}
				}
				/*
				 * if (row.getRowNum() == 0) { continue; }
				 */
				Iterator<Cell> cellIterator = row.cellIterator();
				ArrayList<String> aL = new ArrayList<String>();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						aL.add(String.valueOf(cell.getNumericCellValue()));
					}
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						aL.add(cell.getStringCellValue());
					}
				}
				String jsonStr = aL.get(2).toString();
				aL.stream().forEach(System.out::println);
				response = mapper.readValue(jsonStr, TransferEligibilityResponse.class);
				response.setStatusCode(""+Double.valueOf(aL.get(1)).intValue());
				break;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return response;
	}

}


