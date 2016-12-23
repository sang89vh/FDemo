package com.ff.fdemo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ff.fdemo.dao.IFF0002Dao;
import com.ff.fdemo.model.FF0002Model;
@Component("FF0002DaoImpl")
public class FF0002DaoImpl extends FFBaseDao implements IFF0002Dao{

	protected FF0002DaoImpl() {
		super("ff0002");
	}

	public List<FF0002Model> getHistoricalPriceBySymbol(FF0002Model prm)
			throws SQLException {
		return selectList("getHistoricalPriceBySymbol", prm);
	}

	public void insertHistoricalPrice(FF0002Model prm) throws SQLException {
		insert("insertHistoricalPrice", prm);
		
	}

}
