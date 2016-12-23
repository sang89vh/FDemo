package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ff.fdemo.model.FF000501Model;
import com.ff.fdemo.model.FF000503Model;


public interface IFF0005Dao {
	public void  insertTradeLog(FF000501Model prm) throws SQLException;
public void insertAssetReport(FF000503Model prm) throws SQLException;

	public void deleteAssetReport() throws SQLException;;

	public List<Map>  reportBySymbol() throws SQLException;
	public Map  reportByAll() throws SQLException;
	public Map  reportByGrid() throws SQLException;
}
