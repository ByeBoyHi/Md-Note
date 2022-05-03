package com.itany.sms.transaction.impl;

import java.sql.SQLException;

import com.itany.sms.exception.DataAccessException;
import com.itany.sms.transaction.TransactionManager;
import com.itany.sms.util.JdbcUtil;

public class TransactionManagerImpl implements TransactionManager {
	
	@Override
	public void beginTransaction() {
		try {
			JdbcUtil.getConnection().setAutoCommit(false);
		}catch (SQLException e) {
			throw new DataAccessException("事务开启失败",e);
		}
	}

	@Override
	public void commit() {
		try {
			JdbcUtil.getConnection().commit();
		} catch (SQLException e) {
			throw new DataAccessException("事务提交失败",e);
		}finally{
			JdbcUtil.close();
		}

	}

	@Override
	public void rollback() {
		try {
			JdbcUtil.getConnection().rollback();
		}  catch (SQLException e) {
			throw new DataAccessException("事务回滚失败",e);
		}finally{
			JdbcUtil.close();
		}
	}

}
