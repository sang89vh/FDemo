package com.ff.fdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.ff.fdemo.exception.ErrorCodeEnumImpl;
import com.ff.fdemo.exception.FFException;

public class FFUtils {
	private static final Logger logger = LogManager.getLogger(FFUtils.class);
	private static final SimpleDateFormat YYYYMMDD_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat YYYY_MM_DD_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date convertInputDateToJavaDate(String mydate) throws FFException {
		if (StringUtils.isEmpty(mydate)) {
			return null;
		}
		try {
			// yyyy-MM-dd
			if (mydate.contains("-")) {

				return YYYY_MM_DD_DATE_FORMAT.parse(mydate);

				// yyyyMMdd
			} else {

				return YYYYMMDD_DATE_FORMAT.parse(mydate);

			}

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			FFException wbex = new FFException(
					ErrorCodeEnumImpl.INVALID_PARAMS);
			throw wbex;
		}

	}
	
	public static Long convertInputStringToLong(String input) {
		if (StringUtils.isEmpty(input)) {
			return null;

		} else {
			return Long.parseLong(input);
		}
	}
	public static Date getCurrentDate() {
		Calendar cl = Calendar.getInstance();
		Date currentDate = cl.getTime();
		String strCurrentDate = YYYYMMDD_DATE_FORMAT.format(currentDate);
		Date d = null;
		try {
			d = YYYYMMDD_DATE_FORMAT.parse(strCurrentDate);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return d;
	}
	
	public static List<String> convertStringToInSQLPrm(String input) {

		List<String> output = null;
		if (!StringUtils.isEmpty(input)) {
			input = input.trim();
			output = new ArrayList<String>();
			String[] stra = input.split(",");
			for (String str : stra) {

				str = str.trim();
				if (!StringUtils.isEmpty(str) && !"null".equals(str)) {
					output.add(str);
				}
			}

		}

		return output;
	}
	
	public static void convertStringToInSQLPrm(Map<String, Object> parameter) {
		String listStringId = (String)parameter.get("LIST_OBJECT_ID");
		List<String> listObjectId = convertStringToInSQLPrm(listStringId);
		parameter.put("LIST_OBJECT_ID", listObjectId);
		
	}
}
