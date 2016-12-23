package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FF0002Model;

public interface IFF0002Dao {
	public List<FF0002Model> getHistoricalPriceBySymbol(FF0002Model prm) throws SQLException;
	public void insertHistoricalPrice(FF0002Model prm) throws SQLException;
}
