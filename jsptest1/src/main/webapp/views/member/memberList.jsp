<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/views/common/header.jsp" %>
<%@ include file="/views/common/footer.jsp" %>
<%@ page import="java.util.List,com.web.model.dto.Member"%>
<section>
	<h3>회원조회 결과</h3>
	
	<div>
		<form action="${pageContext.request.contextPath }/member/searchkeyword.do" method="post">
			<input type="text" name="userId">
			<input type="submit" value="검색">
		</form>
	</div>
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>성별</td>
			<td>나이</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>주소</td>
			<td>취미</td>
			<td>가입일</td>
		</tr>
		<tbody>
		<c:forEach var="m" items="${member }">
			<tr>
				<td>${m.userId }</td>
				<td>${m.password }</td>
				<td>${m.userName }</td>
				<td>${m.gender }</td>
				<td>${m.age }</td>
				<td>${m.phone }</td>
				<td>${m.email }</td>
				<td>${m.address }</td>
				<td>
					<c:forEach var="h" items="${m.hobby }">
						<li>${h }</li>
					</c:forEach>
				</td>
				<td>${m.enrollDate }</td>

			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</section>

