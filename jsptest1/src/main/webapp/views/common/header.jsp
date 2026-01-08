<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.model.dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include테스트</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css"/>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<header>
		<h2></h2>
		<img src="<%=request.getContextPath() %>/images/12.jpg" 
		width="200" height="200">
		<div id="login-container">
			<%if(session.getAttribute("loginMember")==null){ %>
				<form action="<%=request.getContextPath() %>/member/login.do" method="post">
					<input type="text" name="userId"><br>
					<input type="password" name="password"><br>
					<input type="submit" value="로그인"> 
					<input type="reset" value="취소">
				</form>
			<%}else { 
				Member m=(Member)session.getAttribute("loginMember");%>
				<h3><%=m.getUserName() %>님 반갑습니다.</h3>
				<button onclick="location.replace('<%=request.getContextPath()%>/logout.do');">로그아웃</button>
			<%} %>
		</div>
		<nav>
			<ul>
				<li>
				<a href="<%=request.getContextPath() %>/views/main.jsp">메인화면</a>
				</li>
				<li>
				<a href="<%=request.getContextPath() %>/views/member/memberlist.do">회원정보</a>
				</li>
				<li><a href="<%=request.getContextPath()%>/member/enrollmember.do">회원가입</a></li>
				<li><a href="">자료실</a></li>
				<li><a href="">갤러리</a></li>
			</ul>
		</nav>
	</header>

	<script>
		$("header>h2").text("해더jsp");
	</script>





