package com.myboxteam.fdemo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myboxteam.fdemo.dao.IFF0004Dao;
import com.myboxteam.fdemo.model.FF000401Model;
import com.myboxteam.fdemo.model.FF000402Model;
@Component("FF0004DaoImpl")
public class FF0004DaoImpl extends FFBaseDao implements IFF0004Dao{

	protected FF0004DaoImpl() {
		super("ff0004");
	}

	public void insertCompany(FF000401Model prm) throws SQLException {
		insert("insertCompany", prm);
	}

	public List<FF000402Model> getAllCompanies() throws SQLException {
		return selectList("getAllCompanies");
	}

	
}
