package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FF000401Model;
import com.ff.fdemo.model.FF000402Model;


public interface IFF0004Dao {
	public void  insertCompany(FF000401Model prm) throws SQLException;
	public List<FF000402Model> getAllCompanies() throws SQLException;
}
