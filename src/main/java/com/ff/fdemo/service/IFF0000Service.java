package com.ff.fdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FF0000Model;

public interface IFF0000Service {
	public List<FF0000Model> getRightEventBySymbol(FF0000Model prm)
			throws SQLException ;
	
	public void insertRightEvent() throws SQLException;
}
