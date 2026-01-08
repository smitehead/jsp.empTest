<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/views/error/error.jsp"%>
    <%@ page import="java.util.List,java.util.Map" %>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 첫 jsp파일</title>
</head>
<body>
	<h2>jsp파일에 대해 알아보자</h2>
	<p>
		html코드에 java문법을 사용할 수 있게 한것
		jsp에서 제공하는 태그를 이용<br>
	</p>
	
	<h3>스크립 트릿</h3>
	<p>
		<%--<% 자바코드 %> --%>
		지역변수 선언, 조건문 ,반복문,메소드 호출,객체 생성등
	</p>
	
	<%
		String name = "banana";
		int age =9;
		String[] names = new String[3];
		names[0]="banana";
		names[1]="nanaba";
		names[2]="nabana";
		request.setAttribute("names", names);
		
		System.out.println(name.length());
	%>
	<p>자바코드를 html에 출력하려면 출력식을 사용한다</p>
	
	<%--<%  = 변수명|| 반환형이있는메소드호출 %> --%>
	<h3><%=name %></h3>
	<p><%=age %></p>
	<ul>	

		<% for(String n : names) { 
		if(n.charAt(0)=='b'){%>
			<li><%=n %></li>
		<%}
		}%>
		</ul>
		<%
			List<Double> height = List.of(180.5,193.2,173.8,172.5,163.2);
			List<Map<String,String>> source=List.of(
					Map.of("src","www.naver.com","title","네이버"),
					Map.of("src","www.youtube.com","title","유투브"),
					Map.of("src","www.google.com","title","구글")
					);
			
			request.setAttribute("height", height);
			request.setAttribute("source", source);
		%>
		
			<% for(Double h : height) {%>
				<p><%=h %></p>
			<%} %>
			
	<% for(Map<String,String> d : source){%>
		<a href="http://<%=d.get("src") %>"><%=d.get("title") %></a>
	<%} %> 
	
	<h3>에러페이지 설정하기</h3>
	<p>
		지시자 태그에서 설정할수 있다
	</p>
	<h3>공통으로 사용하는 페이지 설정하기</h3>
	<p>
		include 태그
	</p>
	<a href="<%=request.getContextPath()%>/views/main.jsp">내용</a>
	
	<h3>실제 서비스 구현하기</h3>
	
	<p>
		mvc2 모델 : html->서블릿 ->jsp로 html을 응답
	</p>
	<h3>
		<a href="<%=request.getContextPath()%>/main.do">HOME</a>
	</h3>
	
	<h3>jstl이용하기</h3>
	<h3>el표현식</h3>
	<p>
		<%--${} == <% %> --%>
	</p>
	
	<% 
		request.setAttribute("name", "banana");
		session.setAttribute("age", 3);
		request.setAttribute("age", 22);//리퀘스트가 작은범위라서 먼저 탐색됨
	%>
	<h4>${name }</h4>
	<h4>${age}</h4>
	<h4>${sessionScope.age}</h4>
	<h4>${requestScope.age>20}</h4>
	<h4>${name=='banana'}</h4>
	
	<h3>jstl이용하기</h3>
	<c:if test="${name =='banana'}">
		<h3>banana love</h3>
		</c:if>
		<c:set var="data" value="<h3>오늘은 7시까지</h3>" scope="request"/>
		
		${data } <!-- 이건 스크립트문을 넣을 수 있어서 위험함 따라서 out사용을 권장함 -->
		<c:out value="${data }" escapeXml=""/>
		
		<!-- for(double d : height) 와 같은 구조 -->
		<c:forEach var="d" items="${height}">
			<c:if test="${d>=180 }">
				<p>${d }</p>
			</c:if>
		</c:forEach>
		
		<c:import var="h" url="/views/common/header.jsp"/> <!-- 변수에 헤더를 넣은상태 -->
		${h}
		<c:forEach var="s" items="${source}">
			<a href="${s.source}">${s.title}</a>
		</c:forEach>
		<jsp:include page="/views/common/footer.jsp"/>
	</body>
</html>