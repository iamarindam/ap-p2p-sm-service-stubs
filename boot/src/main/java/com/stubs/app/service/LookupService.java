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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stubs.app.model.mps.LookUpResponse;
import com.stubs.app.model.mps.RequestedParticipantResponse;
import com.stubs.app.model.mps.SdsResponse;

@Service
public class LookupService {

	//private static final String lookupData = "/LookupData.xlsx";
	public static LookUpResponse getResponse(String proxyValue) {
		ObjectMapper mapper = new ObjectMapper();
		LookUpResponse response = null;

		try {
			//For Dev Local
			//String resource = "./LookupData.xlsx";
			
			//For Dev MC
			String resource = "/fs01/app/stubs-xml/LookupData.xlsx";

			//For QA
			//String resource = "/var/tmp/LookupData.xlsx";
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
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(proxyValue)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(proxyValue)) {
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
				response = mapper.readValue(jsonStr, LookUpResponse.class);
				response.setStatusCode(""+Double.valueOf(aL.get(1)).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static SdsResponse getSdsResponse(String proxyValue) {
		ObjectMapper mapper = new ObjectMapper();
		SdsResponse response = null;

		try {
			//For Dev
			//String resource = "./SdsLookup.xlsx";
			
			//For Dev MC
			String resource = "/fs01/app/stubs-xml/SdsLookup.xlsx";

			//For QA
			//String resource = "/var/tmp/SdsLookup.xlsx";
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
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(proxyValue)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(proxyValue)) {
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
				response = mapper.readValue(jsonStr, SdsResponse.class);
				response.setStatusCode(""+Double.valueOf(aL.get(1)).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static RequestedParticipantResponse getRPResponse(String proxyValue) {
		ObjectMapper mapper = new ObjectMapper();
		RequestedParticipantResponse response = null;

		try {
			//For Dev
			//String resource = "./RequestedParticipantData.xlsx";
			
			//For Dev MC
			String resource = "/fs01/app/stubs-xml/RequestedParticipantData.xlsx";

			//For QA
			//String resource = "/var/tmp/LookupData.xlsx";
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
						if (sheet.getRow(rn).getCell(0).getRawValue().toString().equalsIgnoreCase(proxyValue)) {
							row = sheet.getRow(rn);
							break;
						}
					} else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						if (sheet.getRow(rn).getCell(0).getStringCellValue().toString().equalsIgnoreCase(proxyValue)) {
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
				response = mapper.readValue(jsonStr, RequestedParticipantResponse.class);
				response.setStatusCode(""+Double.valueOf(aL.get(1)).intValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
