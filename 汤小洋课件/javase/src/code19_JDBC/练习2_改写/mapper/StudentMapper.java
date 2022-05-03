package code19_JDBC.练习2_改写.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import code19_JDBC.练习2_改写.entity.Clazz;
import code19_JDBC.练习2_改写.entity.Student;
import code19_JDBC.练习2_改写.util.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs) throws SQLException {
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
		return stu;
	}

}
