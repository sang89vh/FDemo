package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ff.fdemo.model.FF0002Model;

public class ReadDailyPriceExcel {
	public static List<FF0002Model> readDailyPrice(String pathFile) throws IOException {
		FileInputStream file = new FileInputStream(new File(pathFile));

		// Create Workbook instance holding reference to .xlsx file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		// abort first row is header
		rowIterator.next();

		List<FF0002Model> list = new ArrayList<FF0002Model>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			int i = 1;
			FF0002Model ff0002Model = new FF0002Model();
			Double db = null;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Check the cell type and format accordingly
				switch (i) {
				case 1:
					ff0002Model.setSYMBOL(cell.getStringCellValue());
					break;
				case 2:
					ff0002Model.setTRADING_DATE(cell.getDateCellValue());
					break;
				case 3:
					db = cell.getNumericCellValue() * 1000;
					ff0002Model.setOPEN_PRICE(db.longValue());
					break;
				case 4:
					db = cell.getNumericCellValue() * 1000;
					ff0002Model.setHIGH_PRICE(db.longValue());
					break;
				case 5:
					db = cell.getNumericCellValue() * 1000;
					ff0002Model.setLOW_PRICE(db.longValue());
					break;
				case 6:
					db = cell.getNumericCellValue() * 1000;
					ff0002Model.setCLOSE_PRICE(db.longValue());
					break;
				case 7:
					db = cell.getNumericCellValue() * 1000;
					ff0002Model.setVOLUME(db.longValue());
					break;
				}

				i++;
			}
			list.add(ff0002Model);
		}
		file.close();
		return list;

	}


}
