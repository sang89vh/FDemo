package com.myboxteam.fdemo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IFF0005Service {
	
	public void  insertTradeLog(String pathFile) ;

	public void  insertAssertReport(String pathFile) ;
	public void deleteAssetReport() throws SQLException;

	public List<Map> reportBySymbol() throws SQLException;
	public Map reportByAll() throws SQLException ;
	public List<Map> reportByGrid() throws SQLException ;
}
