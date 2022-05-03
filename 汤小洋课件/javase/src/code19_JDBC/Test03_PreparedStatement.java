package code19_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test03_PreparedStatement {
	public static void main(String[] args) {
//		boolean flag = login("tom", "123' or '1=1");
//		System.out.println(flag);
		
		User user = new User();
		user.setUsername("ddd");
		user.setPassword("111");
		user.setAge(25);
		register(user);
		System.out.println("注册成功");
	}

	/*
	 * 用户登陆
	 */
	public static boolean login(String username, String password) {
		// String sql="select id,username,password,age from t_user where username='"+username+"' and password='"+password+"'";
		// String sql = "select id,username,password,age from t_user where username=? and password=?";
		// 建议使用StringBuffer或StringBuilder拼接SQL语句，关键字、表名、列名等独占一行
		String sql=new StringBuilder()
			.append(" select ")
			.append(" 	id,username,password,age ")
			.append(" from  ")
			.append(" 	t_user ")
			.append(" where ")
			.append(" 	username = ? and password = ? ")
			.toString();

		Connection conn = null;
		// Statement stmt=null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			// stmt=conn.createStatement();
			// rs = stmt.executeQuery(sql);

			ps = conn.prepareStatement(sql); // 获取PreparedStatement，需要传入sql，进行预编译
			ps.setString(1, username); // 为占符符?赋值，编号从1开始
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) { // 如果返回结果集中最多只有一条记录，可以使用if
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}

		return false;
	}

	/*
	 * 用户注册
	 */
	public static void register(User user){
		String sql = new StringBuffer()
			.append(" insert into  ")
			.append(" 	t_user ")
			.append(" 		(username,password,age) ")
			.append(" values ")
			.append("  		(?,?,?) ")
			.toString();
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn=JdbcUtil.getConnection();
			ps=conn.prepareStatement(sql);
//			ps.setString(1, user.getUsername());
//			ps.setString(2, user.getPassword());
//			ps.setInt(3, user.getAge());
			// set后的类型只代表第二个参数类型，不代表数据库对应的类型
			ps.setObject(1, user.getUsername()); 
			ps.setObject(2, user.getPassword()); 
			ps.setObject(3, user.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}
}
