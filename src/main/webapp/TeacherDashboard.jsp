<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TeacherDashboard</h1>
<%
String role = (String) session.getAttribute("role");

if(role == null){
    response.sendRedirect("login.jsp");
}
%>

<h2>Welcome ${sessionScope.name}</h2>

<% if(role.equals("STUDENT")) { %>
    <a href="ListTeachersServlet">Chat with Teacher</a>
<% } else { %>
    <a href="ListStudentsServlet">Chat with Student</a>
<% } %>
</body>
</html>