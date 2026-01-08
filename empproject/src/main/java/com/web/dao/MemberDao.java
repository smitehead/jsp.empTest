package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.JDBCTemplate;
import com.web.dto.Member;

public class MemberDao {
	//database에 sql문을 실행하고 결과를 가져오는 역활
	public List<Member> checkSelectAll(Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		List<Member> members = new ArrayList();
		String sql="SELECT * FROM employee";
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
		
		return Member.builder()
				.empId(rs.getString("EMP_ID"))
				.empName(rs.getString("EMP_NAME"))
				.empNo(rs.getString("EMP_NO"))
				.email(rs.getString("EMAIL"))
				.phone(rs.getString("PHONE"))
				.deptCode(rs.getString("DEPT_CODE"))
				.jobCode(rs.getString("JOB_CODE"))
				.salLevel(rs.getString("SAL_LEVEL"))
				.salary(rs.getInt("SALARY"))
				.bonus(rs.getDouble("BONUS"))
				.address(rs.getString("ADDRESS"))
				.managerId(rs.getString("MANAGER_ID"))
				.entDate(rs.getDate("ENT_DATE"))
				.hireDate(rs.getDate("HIRE_DATE"))
				.entYn(rs.getString("ENT_YN"))
				.build();
	}
	
}
