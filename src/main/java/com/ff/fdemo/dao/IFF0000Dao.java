package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FF000001Model;
import com.ff.fdemo.model.FF0000Model;

public interface IFF0000Dao {
	public List<FF000001Model> searchRightEventBySymbol(FF0000Model prm) throws SQLException;
	public void insertRightEvent(FF0000Model prm) throws SQLException;
	public boolean checkRightEvent(FF0000Model prm) throws SQLException;
	
}
