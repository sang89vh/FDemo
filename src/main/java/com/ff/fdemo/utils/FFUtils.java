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

public class FFUtils {
	private static final Logger logger = LogManager.getLogger(FFUtils.class);
	private static final SimpleDateFormat YYYYMMDD_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat YYYY_MM_DD_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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

	public static String getCurrentDateStr() {
		Calendar cl = Calendar.getInstance();
		Date currentDate = cl.getTime();
		String strCurrentDate = YYYY_MM_DD_DATE_FORMAT.format(currentDate);
		return strCurrentDate;
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
		String listStringId = (String) parameter.get("LIST_OBJECT_ID");
		List<String> listObjectId = convertStringToInSQLPrm(listStringId);
		parameter.put("LIST_OBJECT_ID", listObjectId);

	}

	public static Date convertStringToDate(String str_right_date) throws ParseException {
		if (StringUtils.isEmpty(str_right_date)) {
			return null;
		} else if (str_right_date.contains("-")) {
			return YYYY_MM_DD_DATE_FORMAT.parse(str_right_date);
		} else {
			return YYYYMMDD_DATE_FORMAT.parse(str_right_date);
		}

	}
}
