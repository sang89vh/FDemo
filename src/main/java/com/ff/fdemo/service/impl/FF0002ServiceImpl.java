package com.ff.fdemo.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ff.fdemo.dao.IFF0002Dao;
import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.service.IFF0002Service;
import com.ff.fdemo.utils.ReadDailyPriceExcel;

@Service("FF0002ServiceImpl")
public class FF0002ServiceImpl implements IFF0002Service {
	@Autowired
	public IFF0002Dao ff0002Dao;

	@Transactional
	public List<FF0002Model> getHistoricalPriceBySymbol(FF0002Model prm)
			throws SQLException {
		return ff0002Dao.getHistoricalPriceBySymbol(prm);
	}

	@Transactional
	public void insertHistoricalPrice(String pathFile) throws SQLException {
		try {
			List<FF0002Model> data = ReadDailyPriceExcel.readDailyPrice(pathFile);
			
			for (FF0002Model prm : data) {
				ff0002Dao.insertHistoricalPrice(prm);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
