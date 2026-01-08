package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.dto.Member;
import com.web.model.service.MemberService;


@WebServlet("/memeber/memberlist.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

//		members.add(Member.builder()
//				.userId("admin")
//				.password("1234")
//				.userName("관리자")
//				.age(32)
//				.gender("M")
//				.phone("010")
//				.email("admin@.com")
//				.address("바나나 시 바나나")
//				.build());
//		
//		members.add(Member.builder()
//				.userId("banana")
//				.password("1111")
//				.userName("바나나")
//				.age(2)
//				.gender("바")
//				.phone("010")
//				.email("banana@.com")
//				.address("바나나 시 바나나")
//				.build());
//		System.out.println(members);
		List<Member> members = new MemberService().serchMemberAll();
		RequestDispatcher rd = request.getRequestDispatcher("/views/member/memberList.jsp");
		request.setAttribute("member", members);//데이터를 받고 필요없으니 리퀘스트 계속필요하면 세션
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
