package code19_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Test07_元数据 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();

			/*
			 * 获取数据库元数据
			 */
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.getUserName());

			ps = conn.prepareStatement("select * from t_user");
			rs = ps.executeQuery();
			
			/*
			 * 获取结果集元数据
			 */
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("总列数："+rsmd.getColumnCount());
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnTypeName(i));
				System.out.println(rsmd.getTableName(i));
				System.out.println(rsmd.isAutoIncrement(i));
				System.out.println(rsmd.isNullable(i)); // 0表示为null，1表示not null
				System.out.println("--------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps);
		}
	}
}
