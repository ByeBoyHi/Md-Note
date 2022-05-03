package com.itany.sms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itany.sms.exception.DataAccessException;

/**
 * JDBC工具类，使用druid连接池
 */
public class JdbcUtil {

	private static DataSource dataSource;
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	/**
	 * 初始化连接池
	 */
	static {
		Properties p = new Properties();
		try {
			p.load(JdbcUtil.class.getClassLoader().getResourceAsStream(
					"datasource.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("JdbcUtil初始化失败：" + e);
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @throws DataAccessException
	 */
	public static Connection getConnection() throws DataAccessException {
		Connection conn = local.get();
		if (conn == null) {
			try {
				conn = dataSource.getConnection();
				local.set(conn);
			} catch (SQLException e) {
				throw new DataAccessException("获取连接失败", e);
			}
		}
		return conn;
	}

	/**
	 * 关闭资源
	 * 
	 * @throws DataAccessException
	 */
	public static void close(PreparedStatement ps, ResultSet rs)
			throws DataAccessException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DataAccessException("ResultSet关闭失败", e);
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DataAccessException("PreparedStatement关闭失败", e);
			}
		}
	}

	public static void close(){
		Connection conn = local.get();
		if(conn!=null){
			try {
				conn.close(); //释放连接
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			local.remove(); //将ThreadLocal清空
		}
	}
}
