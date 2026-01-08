package com.web.model;

import java.sql.Connection;
import java.util.List;

import com.web.common.JDBCTemplate;
import com.web.dao.MemberDao;
import com.web.dto.Member;

public class MemberModel {
	private MemberDao dao = new MemberDao();
	public List<Member> checkMember() {
		
		
		Connection conn = JDBCTemplate.getConnection();

		List<Member>members = dao.checkSelectAll(conn);
		
		JDBCTemplate.close(conn);
		
		return members;
		
	}
}
