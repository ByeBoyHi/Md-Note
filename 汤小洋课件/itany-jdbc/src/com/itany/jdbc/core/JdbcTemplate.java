package com.itany.jdbc.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.util.JdbcUtil;
import com.itany.jdbc.util.RowMapper;

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
			throw new DataAccessException("执行query方法失败",e);
		} finally {
			JdbcUtil.close(ps, rs); //此处不能关闭Connection
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
			throw new DataAccessException("执行update方法失败",e);
		} finally {
			JdbcUtil.close(ps, rs); //此处不能关闭Connection
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
			throw new DataAccessException("执行save方法失败",e);
		} finally {
			JdbcUtil.close(ps, rs);
		}
		return null;
	}

}
