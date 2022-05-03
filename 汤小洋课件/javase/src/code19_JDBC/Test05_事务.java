package code19_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test05_事务 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
			
		try {
			conn=JdbcUtil.getConnection();
			// 关闭自动提交事务
			conn.setAutoCommit(false);
			
			ps=conn.prepareStatement("insert into t_user values (null,'yyy','111',20)");
			ps.executeUpdate();
			
			ps=conn.prepareStatement("insert into t_user values (null,'aaa','111',18)");
			ps.executeUpdate();
			
			// 提交事务
			conn.commit();
			
			System.out.println("同时添加两个用户成功！");
		} catch (SQLException e) {
			// 回滚事务
			try {
				conn.rollback();
				System.out.println("操作被回滚，出现异常："+e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}
}
