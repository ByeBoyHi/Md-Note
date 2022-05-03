package code19_JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Test08_连接池 {
	public static void main(String[] args) throws SQLException {
		test02();
	}

	// 基本用法
	public static void test01() throws SQLException {
		// 创建数据库连接池（数据源）
		// BasicDataSource ds = new BasicDataSource();
		DruidDataSource ds = new DruidDataSource();

		// 设置连接池的属性（参数）
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("");

		ds.setInitialSize(10); // 初始化连接数
		ds.setMaxActive(50); // 最大活跃连接数
		// ds.setMaxIdle(20); // 最大空闲连接数
		ds.setMinIdle(5); // 最小空闲连接数
		ds.setMaxWait(6000); // 超时等待时间，单位为毫秒

		// 从连接池中获取连接
		Connection conn = ds.getConnection();
		System.out.println(conn);

	}

	// 读取属性文件中的配置信息，创建连接池
	public static void test02() {
		Properties p = new Properties();
		try {
			p.load(Test08_连接池.class.getClassLoader().getResourceAsStream(
					"datasource.properties"));
			// DataSource ds = BasicDataSourceFactory.createDataSource(p);
			DataSource ds = DruidDataSourceFactory.createDataSource(p);
			System.out.println(ds.getConnection());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
