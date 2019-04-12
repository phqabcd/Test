package com.test.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class JDBCUtil02 {
	static ComboPooledDataSource dataSource=null;
	static {
		dataSource=new ComboPooledDataSource();
	}
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	public static Connection getConn() throws SQLException {
			return dataSource.getConnection();//如果连接不到抛出异常不在执行
	}
	private static void closeRs(ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	private static void closeSt(Statement st) {
		try {
			if(st!=null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void closeConn(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void release(Connection conn,Statement st,ResultSet rs) {
		closeSt(st);
		closeRs(rs);
		closeConn(conn);
	}
	public static void release(Connection conn,Statement st) {
		closeSt(st);
		closeConn(conn);
	}
}
