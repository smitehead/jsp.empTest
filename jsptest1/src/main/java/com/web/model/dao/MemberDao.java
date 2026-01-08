package com.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.JDBCTemplate;
import com.web.model.dto.Member;

public class MemberDao {
	//database에 sql문을 실행하고 결과를 가져오는 역활
	public List<Member> selectMemberByAll(Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		List<Member> members = new ArrayList();
		String sql="SELECT * FROM MEMBER";
		try {
			pstmt =conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				members.add(getMember(rs));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return members;
	}
	private Member getMember(ResultSet rs) throws SQLException {
		String[] hobby=rs.getString("hobby")!=null?rs.getString("hobby").split(",") : new String[] {};
		return Member.builder()
				.userId(rs.getString("userid"))
				.password(rs.getString("password"))
				.userName(rs.getString("userName"))
				.gender(rs.getString("gender"))
				.age(rs.getInt("age"))
				.phone(rs.getString("phone"))
				.email(rs.getString("email"))
				.address(rs.getString("address"))
				.hobby(hobby)
				.enrollDate(rs.getDate("enrollDate"))
				.build();
	}
	public List<Member> searchMemberById(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="SELECT * FROM MEMBER WHERE USERID LIKE '%'||?||'%'";
		List<Member> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, "%"+id+"%");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getMember(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3,m.getUserName());
			pstmt.setString(4,m.getGender());
			pstmt.setInt(5,	m.getAge());
			pstmt.setString(6,	m.getEmail());
			pstmt.setString(7,	m.getPhone());
			pstmt.setString(8,	m.getAddress());
			pstmt.setString(9,	String.join(",",m.getHobby()));
			
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
}
