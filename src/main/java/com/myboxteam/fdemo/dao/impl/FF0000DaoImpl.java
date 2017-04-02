package com.myboxteam.fdemo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.myboxteam.fdemo.dao.IFF0000Dao;
import com.myboxteam.fdemo.model.FF000001Model;
import com.myboxteam.fdemo.model.FF0000Model;
@Component("FF0000DaoImpl")
public class FF0000DaoImpl extends FFBaseDao implements IFF0000Dao{
	private static final Logger logger = LogManager.getLogger(FF0000DaoImpl.class);
	protected FF0000DaoImpl() {
		super("ff0000");
	}

	public List<FF000001Model> searchRightEventBySymbol(FF0000Model prm)
			throws SQLException {
		return selectList("searchRightEventBySymbol", prm);
	}

	public void insertRightEvent(FF0000Model prm) throws SQLException {
		
		insert("insertRightEvent", prm);
		
	}

	public boolean checkRightEvent(FF0000Model prm) throws SQLException {
		Integer count = (Integer) selectOne("checkRightEvent", prm);
		if(count == 0){
			return true;
		}else{
			return false;
		}
		
	}

}
