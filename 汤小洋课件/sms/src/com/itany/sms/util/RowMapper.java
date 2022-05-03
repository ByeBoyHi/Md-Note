package com.itany.sms.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 回调接口，用于对结果集中的每一行记录进行处理
 */
public interface RowMapper<T> {
	
	/**
	 * 对每一行记录进行映射，转换为对象
	 * @param rs 结果集
	 * @return  每一行记录处理的结果，返回相应的对象
	 */
	public T mapRow(ResultSet rs) throws SQLException;
	
}
