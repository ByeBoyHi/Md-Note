package com.itany.sms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.sms.entity.Clazz;
import com.itany.sms.entity.Student;
import com.itany.sms.util.RowMapper;

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
