<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	List<Teacher> users = (List<Teacher>) request.getAttribute("teachers");
	%>

	<h3>Select Teacher</h3>
<%
Integer currentUserId = (Integer) session.getAttribute("userId");

for(Teacher t : users) {
    //if(t.getTid() != currentUserId) {
%>
        <a href="chat.jsp?receiverId=<%=t.getTid()%>"> <%=t.getTname()%>
	</a>
	<br>
<%
    //}
}
%>
</body>
</html>