package code19_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test06_批处理 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into t_user values (null,?,?,?)");

			long start = System.currentTimeMillis();
			for (int i = 0; i <= 300000; i++) { // 30万条
				ps.setString(1, "name" + i);
				ps.setString(2, "123");
				ps.setInt(3, 18);
				// ps.executeUpdate();

				ps.addBatch(); // 添加批处理，放到缓冲区中

				// 设置批处理大小
				if (i % 50 == 0) {
					ps.executeBatch(); // 执行批处理
					conn.commit();
				}
			}

			ps.executeBatch();
			conn.commit();

			long end = System.currentTimeMillis();
			System.out.println(end - start + "ms");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps);
		}
	}
}
