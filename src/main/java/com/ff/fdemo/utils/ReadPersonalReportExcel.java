package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.model.FF000501Model;

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
			model.setBuy_sell(row.getCell(2).getStringCellValue());
			model.setSymbol(row.getCell(3).getStringCellValue());
			model.setVolume(row.getCell(6).getNumericCellValue());
			model.setValue(row.getCell(8).getNumericCellValue());
			model.setTax(row.getCell(9).getNumericCellValue());
			model.setFee(row.getCell(10).getNumericCellValue());

			list.add(model);

		}

		return list;


	}
	public static void main(String[] args) {
		try {
			List<FF000501Model> list = ReadPersonalReportExcel.readTradeLog("F:\\ffdata\\report\\LichSuKhopLenh_058C054323_2.xls");
			for (FF000501Model ff000501Model : list) {
				System.out.print(ff000501Model.getBuy_sell());System.out.print("-");
				System.out.print(ff000501Model.getSymbol());System.out.print("-");
				System.out.print(ff000501Model.getTrading_code());System.out.print("-");
				System.out.print(ff000501Model.getFee());System.out.print("-");
				System.out.print(ff000501Model.getTax());System.out.print("-");
				System.out.print(ff000501Model.getValue());System.out.print("-");
				System.out.println(ff000501Model.getVolume());
			}
			
		} catch (IOException e) {
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
