package com.itany;

import java.sql.Connection;

import com.itany.jdbc.util.JdbcUtil;

public class Test {
	public static void main(String[] args) {
		Connection conn = JdbcUtil.getConnection();
		System.out.println(conn);
	}
}
