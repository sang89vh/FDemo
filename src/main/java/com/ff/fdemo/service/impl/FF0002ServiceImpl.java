package com.ff.fdemo.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ff.fdemo.dao.IFF0002Dao;
import com.ff.fdemo.dao.impl.FF0000DaoImpl;
import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.service.IFF0002Service;
import com.ff.fdemo.utils.ReadDailyPriceCSV;
import com.ff.fdemo.utils.ReadDailyPriceExcel;

@Service("FF0002ServiceImpl")
public class FF0002ServiceImpl implements IFF0002Service {
	
	private static final Logger logger = LogManager.getLogger(FF0002ServiceImpl.class);
	
	@Autowired
	public IFF0002Dao ff0002Dao;

	@Transactional
	public List<FF0002Model> getHistoricalPriceBySymbol(FF0002Model prm)
			throws SQLException {
		return ff0002Dao.getHistoricalPriceBySymbol(prm);
	}

	@Transactional
	public void insertHistoricalPriceBVS(String pathFile,String exchange){
		try {
			List<FF0002Model> data = ReadDailyPriceExcel.readDailyPrice(pathFile);
			
			for (FF0002Model prm : data) {
				prm.setMarket(exchange);
				try {
					ff0002Dao.insertHistoricalPrice(prm);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}

	}
	
	@Transactional
	public void insertHistoricalPriceCafeF(String pathFile,String exchange){
		try {
			List<FF0002Model> data = ReadDailyPriceCSV.readDailyPrice(pathFile);
			
			for (FF0002Model prm : data) {
				prm.setMarket(exchange);
				try {
					ff0002Dao.insertHistoricalPrice(prm);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}

	}

}
