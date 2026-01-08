package com.web.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//데이터 베이스 접근시 사용하는 메소드를 제공하는 클래스
public class JDBCTemplate {
	//DB접속메소드
	public static Connection getConnection() {
		Connection conn =null;
		try {
			//클래스 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@teacherdev09.kro.kr:8877:xe",
					"bs","bs");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
 	
	//객체 반환 메소드
	public static void close(Connection val) {
		try {
			if(val!=null&&!val.isClosed()) {
				val.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(Statement val) {
		try {
			if(val!=null&&!val.isClosed()) {
				val.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(ResultSet val) {
		try {
			if(val!=null&&!val.isClosed()) {
				val.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//트렌젝션 처리
	
	public static void commit(Connection val) {
		try {
			if(val!=null&&!val.isClosed()) {
				val.commit();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection val) {
		try {
			if(val!=null&&!val.isClosed()) {
				val.rollback();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
