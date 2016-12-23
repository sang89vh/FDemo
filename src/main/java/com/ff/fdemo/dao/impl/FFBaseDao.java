package com.ff.fdemo.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ff.fdemo.controller.FF0000Controller;
import com.ff.fdemo.dao.IFFDao;
import com.ff.fdemo.model.FFBaseModel;

public class FFBaseDao extends SqlSessionDaoSupport implements IFFDao {
	
	private static final Logger logger = LogManager.getLogger(FFBaseDao.class);
	
	protected String mNamespace;

	protected FFBaseDao(String namespace) {
		mNamespace = namespace;
	}

	@Override
	@Resource(name = "sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public int insert(String name, FFBaseModel prm) throws SQLException {
		return getSqlSession().insert(mNamespace + "." + name, prm);
	}
	public <E> List<E> selectList(String name, FFBaseModel prm)
			throws SQLException {
		List<E> data = getSqlSession().selectList(mNamespace + "." + name, prm);
		return data;
	}
	public <E> List<E> selectList(String name)
			throws SQLException {
		List<E> data = getSqlSession().selectList(mNamespace + "." + name);
		return data;
	}

	public Object selectOne(String name, FFBaseModel parameter)
			throws SQLException {
		return getSqlSession().selectOne(mNamespace + "." + name, parameter);
	}
	public Object selectOne(String name)
			throws SQLException {
		return getSqlSession().selectOne(mNamespace + "." + name);
	}

	public Map<?, ?> getMap(String name, String mapKey) throws SQLException {
		return getSqlSession().selectMap(mNamespace + "." + name, mapKey);
	}


	public int update(String name, FFBaseModel parameter) throws SQLException {
		return getSqlSession().update(mNamespace + "." + name, parameter);
	}
	
	public int delete(String name, FFBaseModel parameter) throws SQLException {
		return getSqlSession().delete(mNamespace+"."+name, parameter);
	}

}
