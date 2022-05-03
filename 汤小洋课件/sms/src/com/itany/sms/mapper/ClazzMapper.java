package com.itany.sms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.sms.entity.Clazz;
import com.itany.sms.util.RowMapper;

public class ClazzMapper implements RowMapper<Clazz>{

	@Override
	public Clazz mapRow(ResultSet rs) throws SQLException {
		Clazz clazz = new Clazz();
		clazz.setId(rs.getInt("id"));
		clazz.setName(rs.getString("name"));
		return clazz;
	}

}
