package code19_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01_操作步骤 {
	public static void main(String[] args) {
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="";
		
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.注册驱动
			Class.forName(driverClassName);
			// 2.获取连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.获取Statement
			stmt = conn.createStatement();
			// 4.执行sql语句
			String sql = "insert into t_user(username,password,age) values ('汤姆','123',18)";
			int num = stmt.executeUpdate(sql); // 调用executeUpdate()方法，返回受影响的行数
			// 5. 处理结果
			System.out.println(num);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源（关闭的顺序与打开的顺序相反）
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
