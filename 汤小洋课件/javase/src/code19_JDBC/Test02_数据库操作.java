package code19_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test02_数据库操作 {
	public static void main(String[] args) {
		// String sql="delete from t_user where id>=5";
		// String sql =
		// "update t_user set password=666,age=18 where username='tom'";
		// String sql="create table t_student(id int,name varchar(100))";
		// String sql="drop table t_student";
		// String sql="drop database wbs18112";
		// update(sql);
		
		// 严禁写select *，原因：1.效率低 2.可读性差 3.可能会导致错误
		String sql="select id,username,password,age from t_user";
		List<User> users = query(sql);
		System.out.println(users);
	}

	/*
	 * 更新操作，适用于：
	 * 	insert/delete/update/create/drop
	 * 		凡是在命令行中返回Query OK, 1 row affected (0.01 sec)的都适用
	 */
	public static void update(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn=JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int num = stmt.executeUpdate(sql);
			System.out.println(num); // 对于更新操作，结果一般无需处理
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}

	/*
	 * 查询操作 
	 */
	public static List<User> query(String sql) {
		List<User> list=new ArrayList<User>();
			
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn=JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 返回查询到的结果，以ResultSet形式返回
			while(rs.next()){ // 作用：1.指向下一条数据 2.返回下一条数据是否存在(在一次循环中，不要多次调用next()方法，会跳过部分数据)
				int id = rs.getInt(1); // 根据列的编号来获取，从1开始
				String username = rs.getString(2);
				String password = rs.getString("password"); // 根据列名来获取
				int age = rs.getInt("age");
				// System.out.println(id+","+username+","+password+","+age);
				
				User user = new User(id, username, password, age);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	
	
}
