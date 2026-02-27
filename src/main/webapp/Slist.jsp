<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	List<Student> users = (List<Student>) request.getAttribute("students");
	%>

	<h3>Select Student</h3>
	<%
	Integer currentUserId = (Integer) session.getAttribute("userId");

	for (Student s : users) {
		//if (s.getSid() != currentUserId) {
	%>
	<a href="Tchat.jsp?receiverId=<%=s.getSid()%>"> <%=s.getSname()%>
	</a>
	<br>
	<%
	//}
	}
	%>
</body>
</html>