package com.myboxteam.fdemo.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myboxteam.fdemo.dao.IFF0004Dao;
import com.myboxteam.fdemo.model.FF000401Model;
import com.myboxteam.fdemo.model.FF000402Model;
import com.myboxteam.fdemo.service.IFF0004Service;
import com.myboxteam.fdemo.utils.FFReadJsonFile;

@Service("FF0004ServiceImpl")
public class FF0004ServiceImpl implements IFF0004Service {

	private static final Logger logger = LogManager
			.getLogger(FF0004ServiceImpl.class);

	@Autowired
	public IFF0004Dao ff0004Dao;

	public void insertCompanies() throws SQLException {

		try {
			List<FF000401Model> companies = FFReadJsonFile.readJsonFile();
			for (FF000401Model ff000401Model : companies) {
				ff0004Dao.insertCompany(ff000401Model);
			}
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

	}
	public List<FF000402Model> getAllCompanies() throws SQLException {
		return ff0004Dao.getAllCompanies();
	}
}
