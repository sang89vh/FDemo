package com.ff.fdemo.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.fdemo.dao.IFF0005Dao;
import com.ff.fdemo.model.FF000501Model;
import com.ff.fdemo.service.IFF0005Service;
import com.ff.fdemo.utils.ReadPersonalReportExcel;

@Service("FF0005ServiceImpl")
public class FF0005ServiceImpl implements IFF0005Service {

	private static final Logger logger = LogManager
			.getLogger(FF0005ServiceImpl.class);

	@Autowired
	public IFF0005Dao ff0005Dao;

	public void insertTradeLog(String pathFile) {

		try {
			List<FF000501Model> list = ReadPersonalReportExcel.readTradeLog(pathFile);

			for (FF000501Model prm : list) {
				ff0005Dao.insertTradeLog(prm);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
