package com.web.model.service;

import java.sql.Connection;
import java.util.List;

import com.web.common.JDBCTemplate;
import com.web.model.dao.MemberDao;
import com.web.model.dto.Member;
import static com.web.common.JDBCTemplate.*;

public class MemberService {
	private MemberDao dao = new MemberDao();
	public List<Member> serchMemberAll() {
		
		//Connection 객체 관리 -> db접속관리 밑 트렌젝션 관리
		
		Connection conn = JDBCTemplate.getConnection();
		//sql문 실행
		List<Member>members = dao.selectMemberByAll(conn);
		
		JDBCTemplate.close(conn);
		
		return members;
		
	}
	public List<Member> searchMemberById(String userId) {
		Connection conn = getConnection();
		List<Member> result = dao.searchMemberById(conn,userId);
		close(conn);
		return result;
	}

	public int saveMember(Member m) {
		Connection conn = getConnection();
		int result = dao.insertMember(conn,m);
		
		//트랜젝션처리
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	public Member login(String userId, String password) {
		Connection conn = getConnection();
		List<Member> members = dao.searchMemberById(conn, userId);
		Member loginMember = members.stream().filter(m->m.getUserId().equals(userId)).findFirst().orElse(null);
		close(conn);
		if(loginMember!=null && loginMember.getPassword().equals(password)) {
			return loginMember;
		}
		return null;
	}
}
