package code19_JDBC.练习1_学生管理系统;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import code19_JDBC.JdbcUtil;

public class StudentTemplate {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	/**
	 * 查询操作
	 */
	public List<Student> query(String sql,Object... params){
		List<Student> list=new ArrayList<Student>();
		try {
			conn=JdbcUtil.getConnection();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rs=ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setHeight(rs.getDouble("height"));
				stu.setBithday(rs.getDate("birthday")); // getDate()返回的是java.sql.Date
				Clazz clazz = new Clazz();
				clazz.setId(rs.getInt("cid"));
				clazz.setName(rs.getString("cname"));
				stu.setClazz(clazz);
				
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 更新操作
	 */
	public void update(String sql,Object... params){
		try {
			conn=JdbcUtil.getConnection();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
	}
}
