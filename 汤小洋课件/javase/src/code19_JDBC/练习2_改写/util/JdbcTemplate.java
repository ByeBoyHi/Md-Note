package code19_JDBC.练习2_改写.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 查询操作
	 */
	public List<T> query(String sql, RowMapper<T> rm, Object... params) {
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rm.mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 更新操作
	 */
	public void update(String sql, Object... params) {
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
	}

	/**
	 * 查询单个对象
	 */
	public T queryForObject(String sql, RowMapper<T> rm, Object... params) {
		List<T> list = query(sql, rm, params);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 保存操作， 返回生成的主键
	 */
	public Integer save(String sql, Object... params) {
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys(); // 获取生成的主键
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

}
