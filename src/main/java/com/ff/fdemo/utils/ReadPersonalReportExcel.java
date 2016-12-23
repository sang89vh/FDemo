package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ff.fdemo.model.FF000501Model;
import com.ff.fdemo.model.FF000503Model;

public class ReadPersonalReportExcel {
	public static List<FF000501Model> readTradeLog(String pathFile) throws IOException, ParseException {
		FileInputStream file = new FileInputStream(new File(pathFile));

		// Create Workbook instance holding reference to .xlsx file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		// abort first row is header
		rowIterator.next();
		List<FF000501Model> list = new ArrayList<FF000501Model>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			FF000501Model model = new FF000501Model();
			
			model.setTrading_code(String.valueOf(row.getCell(1).getNumericCellValue()));
			String bysell = row.getCell(2).getStringCellValue();
			if("Mua".equalsIgnoreCase(bysell)){
				model.setBuy(row.getCell(8).getNumericCellValue());
			}else{
				model.setSell(row.getCell(8).getNumericCellValue());
			}
			model.setSymbol(row.getCell(3).getStringCellValue());
			model.setVolume(row.getCell(6).getNumericCellValue());
			
			model.setTax(row.getCell(9).getNumericCellValue());
			model.setFee(row.getCell(10).getNumericCellValue());

			list.add(model);

		}

		return list;


	}
	
	public static List<FF000503Model> readAssetReport(String pathFile) throws IOException, ParseException {
		FileInputStream file = new FileInputStream(new File(pathFile));

		// Create Workbook instance holding reference to .xlsx file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		// abort first row is header
		rowIterator.next();
		List<FF000503Model> list = new ArrayList<FF000503Model>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			FF000503Model model = new FF000503Model();
			
			model.setSymbol(row.getCell(0).getStringCellValue());
			model.setValue(row.getCell(1).getNumericCellValue());

			list.add(model);

		}

		return list;


	}

}