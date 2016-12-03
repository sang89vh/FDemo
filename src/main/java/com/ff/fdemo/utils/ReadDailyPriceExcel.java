package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadDailyPriceExcel {
	public static void readDailyPrice() {
		try {
			FileInputStream file = new FileInputStream(
					new File(
							"C:\\Users\\Admin\\OneDrive\\FDemoSrc\\src\\main\\resources\\dailyprice\\HOSE.xls"));

			// Create Workbook instance holding reference to .xlsx file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			// abort first row is header
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				int i = 1;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					Object data = null;
					// Check the cell type and format accordingly
					switch (i) {
					case 1:
						data = cell.getStringCellValue();
						break;
					case 2:
						data = cell.getDateCellValue();
						break;
					case 3:
						data = cell.getNumericCellValue();
						break;
					case 4:
						data = cell.getNumericCellValue();
						break;
					case 5:
						data = cell.getNumericCellValue();
						break;
					case 6:
						data = cell.getNumericCellValue();
						break;
					case 7:
						data = cell.getNumericCellValue();
						break;
					}
					System.out.println(data);
					i++;
				}
				System.out.println("");
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReadDailyPriceExcel.readDailyPrice();
	}
}
