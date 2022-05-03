package code19_JDBC.练习2_改写.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JDBC工具类，使用druid连接池
 */
public class JdbcUtil {
	
	private static DataSource dataSource;
	
	/**
	 * 初始化连接池
	 */
	static{
		Properties p = new Properties();
		try {
			p.load(JdbcUtil.class.getClassLoader().getResourceAsStream("datasource.properties"));
			dataSource=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("JdbcUtil初始化失败："+e);
		}
	}
	
	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭资源
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
	
}
