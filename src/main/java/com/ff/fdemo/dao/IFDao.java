package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ff.fdemo.model.FBaseModel;

public interface IFDao {
	public <E> List<E> selectList(String name,FBaseModel parameter) throws SQLException ;
}
