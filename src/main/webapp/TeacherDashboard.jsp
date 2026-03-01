<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String role = (String) session.getAttribute("role");

if (role == null) {
	response.sendRedirect("TeacherLogin.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Dashboard</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
body {
	background: linear-gradient(135deg, #667eea, #764ba2);
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

.dashboard-card {
	width: 450px;
	border-radius: 15px;
	padding: 35px;
}
</style>
</head>

<body>

	<div class="card shadow-lg dashboard-card text-center">

		<h3 class="fw-bold mb-3">Teacher Dashboard</h3>

		<h5 class="mb-4 text-muted">Welcome, ${sessionScope.name}</h5>

		<%
		if (role.equals("STUDENT")) {
		%>

		<div class="d-grid mb-3">
			<a href="ListTeachersServlet" class="btn btn-primary btn-lg">
				Chat with Teacher </a>
		</div>

		<%
		} else {
		%>

		<div class="d-grid mb-3">
			<a href="ListStudentsServlet" class="btn btn-success btn-lg">
				Chat with Student </a>
		</div>

		<%
		}
		%>

		<div class="d-grid">
			<form action="LogoutServlet" method="post" style="display: inline;">
				<button type="submit" class="btn btn-danger">Logout</button>
			</form>
		</div>

	</div>

	<!-- Bootstrap JS -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>