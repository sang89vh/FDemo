package com.ff.fdemo.dao.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.ff.fdemo.dao.IFF0005Dao;
import com.ff.fdemo.model.FF000501Model;
@Component("FF0005DaoImpl")
public class FF0005DaoImpl extends FFBaseDao implements IFF0005Dao{

	protected FF0005DaoImpl() {
		super("ff0005");
	}

	public void insertTradeLog(FF000501Model prm) throws SQLException {
		insert("insertTradeLog", prm);
		
	}


	
}
