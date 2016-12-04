package com.ff.fdemo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ff.fdemo.model.FFBaseModel;

public interface IFFDao {
	public <E> List<E> selectList(String name, FFBaseModel parameter)
			throws SQLException;

	public Map<?, ?> getMap(String name, String mapKey) throws SQLException;

	public int insert(String name, FFBaseModel prm) throws SQLException;

	public FFBaseModel selectOne(String name, FFBaseModel parameter)
			throws SQLException;

	public int update(String name, FFBaseModel parameter) throws SQLException;
	public int delete(String name, FFBaseModel parameter) throws SQLException;
}
