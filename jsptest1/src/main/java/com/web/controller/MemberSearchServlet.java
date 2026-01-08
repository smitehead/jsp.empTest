package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.dto.Member;
import com.web.model.service.MemberService;


@WebServlet("/member/searchkeyword.do")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.클라이언트가 전달한 데이터 가져오기
		String userId = request.getParameter("userId");
		//2.이값이 멤버테이블의 userId컬럼에 있는값인지 확인 있으면 데이터 가져오기
		List<Member> result = new MemberService().searchMemberById(userId);
		//3.화면에 출력할 수 있게 저장
		request.setAttribute("member", result);
		//4.데이터를 출력할 화면을 선택->jsp
		request.getRequestDispatcher("/views/member/memberList.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
