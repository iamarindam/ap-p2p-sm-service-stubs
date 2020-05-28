package com.stubs.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stubs.app.model.mcsend.OiApprovalResponse;
import com.stubs.app.model.mcsend.RFPOiApprovalResponse;
import com.stubs.app.model.mps.HeaderReponse;
import com.stubs.app.model.mps.RIApprovalResponse;

@Service
public class RIService {

public RIApprovalResponse  getRiDetails(String participantId) {
		
	 RIApprovalResponse response = new RIApprovalResponse();
		/*ObjectMapper mapper = new ObjectMapper();
		try {
		    String jsonStr = "{\"businessService\":\"ABCDEFGHIJKLMNOPQRSTU\",\"businessMsgIdentifier\":\"ABCDEFGHIJKLMNOPQRSTUVW\",\"creationDate\":\"ABCDEFGHIJKLMNOPQRS\",\"initiatingParty\":{\"id\":\"ABCDEFGHIJKLMNOPQRSTU\",\"type\":\"ABCDEFGHIJKL\"},\"receivingParty\":{\"id\":\"ABCDEFG\",\"type\":\"ABCDEFGHI\"},\"creditorCustomer\":{\"accountDetails\":{\"accountType\":\"ABCDEFG\",\"accountReference\":\"ABCDEFGHIJKLMNOPQRS\"}},\"transactionIdentification\":{\"initiatorTxId\":\"ABCDEFGHIJK\",\"schemeTxId\":\"ABCDEFGHI\"},\"authorisation\":{\"result\":\"ABCDEFGHIJKLMNOPQRSTU\",\"resultDetails\":\"ABCDEFGHIJKLMNOPQRSTUVWXYZABC\",\"additionalResultInfo\":\"ABCDEFGHI\"},\"settlementInfo\":{\"settlementMethod\":\"ABCDEFGHIJKLMN\",\"clearingSystem\":\"ABCDEFGHI\"}}";
		    response =  mapper.readValue(jsonStr, RfaPiiResponse.class);
		}catch (Exception e){
		    e.printStackTrace();
		}*/
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			//for dev
			//String resource = "./RIDetails.xlsx";
			
			//for sprint and mastercard dev
			String resource = "/fs01/app/stubs-xml/RIDetails.xlsx";
			
			File file = Paths.get(resource).toFile();
			//for QA

		//	String resource = "/var/tmp/RIDetails.xlsx";
//			File file = Paths.get(resource).toFile();

			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
                for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
                    Cell cell = sheet.getRow(rn).getCell(0);
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    	System.out.println(sheet.getRow(rn).getCell(0).getRawValue().toString());
                                    if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
                                                    row = sheet.getRow(rn);
                                                    break;
                                    }
                    } else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    	System.out.println("----"+ sheet.getRow(rn).getCell(0).getRawValue().toString());
                    if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(participantId)) {
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
				mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				response = mapper.readValue(jsonStr, RIApprovalResponse.class);
				
				String headerStr = aL.get(3).toString();
				if(!"NA".equals(headerStr)) {
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
					HeaderReponse hresp = mapper.readValue(headerStr, HeaderReponse.class);
					response.setHeaderReponse(hresp);
				}
				response.setStatusCode(Double.valueOf(aL.get(1).toString()).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return response;
	}

	public OiApprovalResponse getOiDetails(String participantId) {

		OiApprovalResponse response = new OiApprovalResponse();

		ObjectMapper mapper = new ObjectMapper();
		try {
			//for dev
			//String resource = "./OIDetails.xlsx";

			//for sprint and mastercard dev
			String resource = "/fs01/app/stubs-xml/OIDetails.xlsx";

			File file = Paths.get(resource).toFile();
			//for QA

			//	String resource = "/var/tmp/OIDetails.xlsx";
//			File file = Paths.get(resource).toFile();

			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
					Cell cell = sheet.getRow(rn).getCell(0);
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						System.out.println(sheet.getRow(rn).getCell(0).getRawValue().toString());
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.println("----"+ sheet.getRow(rn).getCell(0).getRawValue().toString());
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(participantId)) {
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
				mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				response = mapper.readValue(jsonStr, OiApprovalResponse.class);



				response.setStatusCode(""+Double.valueOf(aL.get(1).toString()).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



		return response;
	}
	
	public RFPOiApprovalResponse getRFPOiDetails(String participantId) {

		RFPOiApprovalResponse response = new RFPOiApprovalResponse();

		ObjectMapper mapper = new ObjectMapper();
		try {
			//for dev
			//String resource = "./RFPOIDetails.xlsx";
 
			//for sprint and mastercard dev
			String resource = "/fs01/app/stubs-xml/RFPOIDetails.xlsx";

			File file = Paths.get(resource).toFile();
			//for QA

			//	String resource = "/var/tmp/rfp-OIDetails.xlsx";
//			File file = Paths.get(resource).toFile();

			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
					Cell cell = sheet.getRow(rn).getCell(0);
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						System.out.println(sheet.getRow(rn).getCell(0).getRawValue().toString());
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.println("----"+ sheet.getRow(rn).getCell(0).getRawValue().toString());
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(participantId)) {
							row = sheet.getRow(rn);
							break;
						}
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
				mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				response = mapper.readValue(jsonStr, RFPOiApprovalResponse.class);



				response.setStatusCode(""+Double.valueOf(aL.get(1).toString()).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



		return response;
	}
}
