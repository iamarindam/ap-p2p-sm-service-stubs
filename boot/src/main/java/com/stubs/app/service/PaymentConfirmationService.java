package com.stubs.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
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
import com.stubs.app.model.payconf.PaymentConfirmationCoreResponse;
import com.stubs.app.model.payconf.PaymentConfirmationCoreUpdateResponse;
import com.stubs.app.model.payconf.PaymentConfirmationRIResponse;

@Service
public class PaymentConfirmationService {

	public PaymentConfirmationCoreResponse informPaymentConfToCore(String participantId) {
		PaymentConfirmationCoreResponse response = new PaymentConfirmationCoreResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			URL resource = LookupService.class.getResource("/PaymentConfirmToCore.xlsx");
			File file = Paths.get(resource.toURI()).toFile();
			//String resource = "/var/tmp/PaymentConfirmToCore.xlsx";
			//File file = Paths.get(resource).toFile();

			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
					Cell cell = sheet.getRow(rn).getCell(0);
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
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
				//mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				response = mapper.readValue(jsonStr, PaymentConfirmationCoreResponse.class);
				response.setStatusCode(String.valueOf(aL.get(1).substring(0, 3)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public PaymentConfirmationRIResponse informPaymentConfToRI(String participantId) {
		PaymentConfirmationRIResponse response = new PaymentConfirmationRIResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			//For Local
			//String resource = "./PaymentConfirmToRI.xlsx";
			//File file = Paths.get(resource.toURI()).toFile();
			
			//For UNIX System
			//String resource = "/var/tmp/PaymentConfirmToRI.xlsx";
			
			//For MC deployment system
			String resource = "/fs01/app/stubs-xml/PaymentConfirmToRI.xlsx";
			
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
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
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
				response = mapper.readValue(jsonStr, PaymentConfirmationRIResponse.class);
				response.setStatusCode(String.valueOf(aL.get(1).substring(0, 3)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public PaymentConfirmationCoreUpdateResponse paymentConfUpdateToCore(String participantId) {
		PaymentConfirmationCoreUpdateResponse response = new PaymentConfirmationCoreUpdateResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			URL resource = LookupService.class.getResource("/PaymentConfirmUpdateCore.xlsx");
			File file = Paths.get(resource.toURI()).toFile();

			//String resource = "/var/tmp/PaymentConfirmUpdateCore.xlsx";
			//File file = Paths.get(resource).toFile();
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				for (int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++) {
					if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(participantId)) {
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
				mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				response = mapper.readValue(jsonStr, PaymentConfirmationCoreUpdateResponse.class);
				response.setStatusCode(String.valueOf(aL.get(1).substring(0, 3)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	

}
