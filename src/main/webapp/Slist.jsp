<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Student</title>
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

.list-card {
	width: 500px;
	border-radius: 15px;
	padding: 30px;
	max-height: 80vh;
	overflow-y: auto;
}
</style>

</head>
<body>

	<%
	List<Student> users = (List<Student>) request.getAttribute("students");
	Integer currentUserId = (Integer) session.getAttribute("userId");
	%>
	<div class="card shadow-lg list-card">

		<div class="text-center mb-4">
			<h3 class="fw-bold">Select Student</h3>
			<p class="text-muted">Choose a student to start chatting</p>
		</div>

		<div class="list-group mb-4">

			<%
			if (users != null && !users.isEmpty()) {
				for (Student s : users) {
			%>

			<a href="Tchat.jsp?receiverId=<%=s.getSid()%>"
				class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">

				<span><%=s.getSname()%></span> <span
				class="badge bg-primary rounded-pill"> Chat </span>

			</a>

			<%
			}
			} else {
			%>

			<div class="alert alert-warning text-center">No students
				available.</div>

			<%
			}
			%>

		</div>

		<div class="d-grid">
			<a href="TeacherDashboard.jsp" class="btn btn-outline-secondary">
				Back to Dashboard </a>
		</div>

	</div>

	<!-- Bootstrap JS -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>