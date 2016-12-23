package com.ff.fdemo.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.fdemo.dao.IFF0005Dao;
import com.ff.fdemo.model.FF000501Model;
import com.ff.fdemo.model.FF000503Model;
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

	public void insertAssertReport(String pathFile) {
		try {
			List<FF000503Model> list = ReadPersonalReportExcel.readAssetReport(pathFile);

			for (FF000503Model prm : list) {
				ff0005Dao.insertAssetReport(prm);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	public void deleteAssetReport() throws SQLException{
				ff0005Dao.deleteAssetReport();
		
	}

	public List<Map> reportBySymbol() throws SQLException {
		return ff0005Dao.reportBySymbol();
	}
	public Map reportByAll() throws SQLException {
		return ff0005Dao.reportByAll();
	}

	public Map reportByGrid() throws SQLException {
		return ff0005Dao.reportByGrid();
	}

}
