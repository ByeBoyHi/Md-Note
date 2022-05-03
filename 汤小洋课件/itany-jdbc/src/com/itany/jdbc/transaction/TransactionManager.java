package com.itany.jdbc.transaction;

public interface TransactionManager {
	public void beginTransaction();

	public void commit();

	public void rollback();
}
