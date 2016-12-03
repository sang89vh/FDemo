package com.ff.fdemo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ff.fdemo.dao.IFDao;
import com.ff.fdemo.model.FBaseModel;

public class FBaseDao extends SqlSessionDaoSupport implements IFDao{
	protected String mNamespace;
	protected FBaseDao(String namespace){
		mNamespace = namespace;
	}
	
	@Override
	@Resource(name="sqlSessionFactory") 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public <E> List<E> selectList(String name,
			FBaseModel prm) throws SQLException {
		List<E> data = getSqlSession().selectList(mNamespace + "." + name, prm);
		return data;
	}
	
}
