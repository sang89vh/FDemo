package com.myboxteam.fdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.myboxteam.fdemo.model.FF0002Model;

public interface IFF0002Service {
	public List<FF0002Model> getHistoricalPriceBySymbol(FF0002Model prm)
			throws SQLException ;
	
	public void insertHistoricalPriceBVS(String pathFile,String exchange);

	public void insertHistoricalPriceCafeF(String pathFile,String exchange);
}
