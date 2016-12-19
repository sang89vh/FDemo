package com.ff.fdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FF000402Model;

public interface IFF0004Service {
	
	public void insertCompanies() throws SQLException;
	public List<FF000402Model> getAllCompanies() throws SQLException ;
}
