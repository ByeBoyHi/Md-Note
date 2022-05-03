package code19_JDBC.练习2_改写.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import code19_JDBC.练习2_改写.entity.Clazz;
import code19_JDBC.练习2_改写.util.RowMapper;

public class ClazzMapper implements RowMapper<Clazz>{

	@Override
	public Clazz mapRow(ResultSet rs) throws SQLException {
		Clazz clazz = new Clazz();
		clazz.setId(rs.getInt("id"));
		clazz.setName(rs.getString("name"));
		return clazz;
	}

}
