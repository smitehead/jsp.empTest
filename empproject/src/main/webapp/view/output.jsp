<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List,com.web.dto.Member"%>

	<% 
		List<Member> members = (List)request.getAttribute("member");	
	%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
		<tr>
			<td>emp_id</td>
			<td>emp_name</td>
			<td>emp_no</td>
			<td>email</td>
			<td>phone</td>
			<td>dept_code</td>
			<td>job_code</td>
			<td>sal_level</td>
			<td>bonus</td>
			<td>manager_id</td>
			<td>hire_date</td>
			<td>ent_date</td>
			<td>ent_yn</td>
		</tr>
		<tbody>
			<%for(Member rd : members){%>
			<tr>
				<td><%=rd.getEmpId()%></td>
				<td><%=rd.getEmpName()%></td>
				<td><%=rd.getEmpNo()%></td>
				<td><%=rd.getEmail()%></td>
				<td><%=rd.getPhone()%></td>
				<td><%=rd.getDeptCode()%></td>
				<td><%=rd.getJobCode()%></td>
				<td><%=rd.getAddress()%></td>
				<td><%=rd.getSalLevel()%></td>
				<td><%=rd.getSalary()%></td>
				<td><%=rd.getBonus()%></td>
				<td><%=rd.getManagerId()%></td>
				<td><%=rd.getHireDate()%></td>
				<td><%=rd.getEntDate()%></td>
				<td><%=rd.getEntYn()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>