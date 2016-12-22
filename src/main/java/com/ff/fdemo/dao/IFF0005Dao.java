package com.ff.fdemo.dao;

import java.sql.SQLException;

import com.ff.fdemo.model.FF000501Model;


public interface IFF0005Dao {
	public void  insertTradeLog(FF000501Model prm) throws SQLException;
}
