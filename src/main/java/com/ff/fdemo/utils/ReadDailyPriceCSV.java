package com.ff.fdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.ff.fdemo.model.FF0002Model;

public class ReadDailyPriceCSV {
	public static List<FF0002Model> readDailyPrice(String pathFile) throws IOException, ParseException {
		List<FF0002Model> list = new ArrayList<FF0002Model>();
		// <Ticker>,<DTYYYYMMDD>,<Open>,<High>,<Low>,<Close>,<Volume>
		Reader in = null;

		in = new FileReader(pathFile);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		Iterator<CSVRecord> rowIterator = records.iterator();
		// abort first row is header
		rowIterator.next();
		Double dbval = null;
		while (rowIterator.hasNext()) {
			CSVRecord record = rowIterator.next();

			FF0002Model ff0002Model = new FF0002Model();

			ff0002Model.setSYMBOL(record.get(0));

			ff0002Model.setTRADING_DATE(FFUtils.convertYYYYMMDDToDate(record.get(1)));

			dbval = Double.parseDouble(record.get(2))*1000;
			ff0002Model.setOPEN_PRICE(dbval.longValue());

			dbval = Double.parseDouble(record.get(3))*1000;
			ff0002Model.setHIGH_PRICE(dbval.longValue());

			dbval = Double.parseDouble(record.get(4))*1000;
			ff0002Model.setLOW_PRICE(dbval.longValue());

			dbval = Double.parseDouble(record.get(5))*1000;
			ff0002Model.setCLOSE_PRICE(dbval.longValue());

			dbval = Double.parseDouble(record.get(6))*1000;
			ff0002Model.setVOLUME(dbval.longValue());

			list.add(ff0002Model);

		}

		return list;

	}
}
