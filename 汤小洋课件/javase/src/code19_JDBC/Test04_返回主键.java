package code19_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04_返回主键 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_user ")
			.append(" 		(username,password,age) ")
			.append(" values ")
			.append(" 		('lisi','123',18) ")
			.toString();
			
		try {
			conn=JdbcUtil.getConnection();
			// 传入常量值RETURN_GENERATED_KEYS，表示返回生成的主键
			ps=conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			//获取存储主键的结果集
			rs=ps.getGeneratedKeys();
			while(rs.next()){ //可能是复合主键
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}
}
