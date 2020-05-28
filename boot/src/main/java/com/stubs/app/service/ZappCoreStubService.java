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
import com.stubs.app.model.mps.HeaderReponse;
import com.stubs.app.model.mps.RfaPiiResponse;
import com.stubs.app.model.mps.ZappUpdateResponse;

@Service
public class ZappCoreStubService {

	@SuppressWarnings("resource")
	public RfaPiiResponse  getPiiDetails(String participantId) {
		System.out.println("participantId :"+participantId);
		RfaPiiResponse response = new RfaPiiResponse();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			//File file = Paths.get("/var/tmp/ZappToSmRIDetails.xlsx").toFile();

			//for dev
			String resource = "./ZappToSmRIDetails.xlsx";

			//for QA
		//	String resource = "/var/tmp/ZappToSmRIDetails.xlsx";

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
				response = mapper.readValue(jsonStr, RfaPiiResponse.class);
				
				String headerStr = aL.get(3).toString();
				System.out.println("headerStr :"+headerStr);
				System.out.println("Condition :"+(!"NA".equals(headerStr)));
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
	
@SuppressWarnings("resource")
public ZappUpdateResponse  updatePiiDetails(String participantId) {
		
		ZappUpdateResponse response = new ZappUpdateResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			//for QA
			//File file = Paths.get("/var/tmp/ZappToSmRIUpdateDetails.xlsx").toFile();

			//for dev
			String resource = "./ZappToSmRIUpdateDetails.xlsx";
			File file = Paths.get(resource).toFile();

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
				response = mapper.readValue(jsonStr, ZappUpdateResponse.class);
				
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
}
