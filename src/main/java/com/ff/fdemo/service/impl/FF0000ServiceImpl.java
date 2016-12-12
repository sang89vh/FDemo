package com.ff.fdemo.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ff.fdemo.dao.IFF0000Dao;
import com.ff.fdemo.dao.impl.FF0000DaoImpl;
import com.ff.fdemo.model.FF0000Model;
import com.ff.fdemo.service.IFF0000Service;
import com.ff.fdemo.utils.FFDataFeed;

@Service("FF0000ServiceImpl")
public class FF0000ServiceImpl implements IFF0000Service {
	private static final Logger logger = LogManager.getLogger(FF0000DaoImpl.class);
	@Autowired
	public IFF0000Dao ff0000Dao;

	@Transactional
	public List<FF0000Model> getRightEventBySymbol(FF0000Model prm)
			throws SQLException {
		return ff0000Dao.getRightEventBySymbol(prm);
	}

	@Transactional
	public void insertRightEvent() throws SQLException {
		try {
			List<FF0000Model> data = FFDataFeed.readRightEvent();
			
			for (FF0000Model prm : data) {
				
				//check if this event existing on db then do nothing else insert to db
				//check existing on db
				
				//doesn't existing
				
				//else insert to db
				ff0000Dao.insertRightEvent(prm);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}

	}

}