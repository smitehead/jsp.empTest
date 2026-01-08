package com.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.dto.Member;
import com.web.model.service.MemberService;


@WebServlet("/member/memberenrollend.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		String userName = request.getParameter("userName");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String phone = request.getParameter("phone");
//		String address = request.getParameter("address");
//		String enrollDate = (request.getParameter("enrollDate"));
//		String[] hobby = request.getParameter("hobby").split(",");
		
		Map<String,String[]> params= request.getParameterMap();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		String[] hobby = request.getParameterValues("hobby");
		Member m = Member.builder()
				.userId(userId)
				.password(password)
				.userName(userName)
				.age(age)
				.gender(gender)
				.email(email)
				.phone(phone)
				.address(address)
				.hobby(hobby)
				.build();
		
		//가져온 데이터 db에 저장
		
		int result = new MemberService().saveMember(m);
		
		//3저장결과에 따라 페이지 선택
		
		if(result > 0) {
			//저장성공
			response.sendRedirect(request.getContextPath()+"/main.do");
			request.getRequestDispatcher(address);
			
		}else {
			//저장실패
			response.sendRedirect(request.getContextPath()+"/member/MemberEnroll.do");
		}
	}

}
