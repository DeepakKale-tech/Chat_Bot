<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Role Selection</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.card-custom {
	width: 420px;
	border-radius: 15px;
	padding: 30px;
}

.hidden-section {
	display: none;
}
</style>
</head>
<body>
	<div class="text-center text-white mb-4">
		<h1 class="fw-bold display-5">Welcome to Student - Teacher Chat Module Applicataion</h1>
	</div>
	<div class="card shadow-lg card-custom bg-white text-center">

		<h3 class="mb-4">Select Your Role</h3>

		<!-- First Screen -->
		<div id="roleSelection">
			<button class="btn btn-primary w-100 mb-3"
				onclick="showOptions('student')">Student</button>

			<button class="btn btn-success w-100"
				onclick="showOptions('teacher')">Teacher</button>
		</div>

		<!-- Second Screen -->
		<div id="actionSelection" class="hidden-section">

			<h5 id="selectedRoleTitle" class="mb-4"></h5>

			<a id="loginLink" class="btn btn-outline-dark w-100 mb-3"> Login
			</a> <a id="registerLink" class="btn btn-outline-secondary w-100 mb-3">
				Register </a>

			<button class="btn btn-link mt-2" onclick="goBack()">← Back
			</button>
		</div>

	</div>

	<!-- Bootstrap JS -->
	<script src="js/bootstrap.bundle.min.js"></script>

	<script>
		function showOptions(role) {

			document.getElementById("roleSelection").style.display = "none";
			document.getElementById("actionSelection").style.display = "block";

			document.getElementById("selectedRoleTitle").innerText = role
					.charAt(0).toUpperCase()
					+ role.slice(1) + " Options";

			if (role === "student") {
				document.getElementById("loginLink").href = "StudentLogin.jsp";
				document.getElementById("registerLink").href = "StudentRegister.jsp";
			} else {
				document.getElementById("loginLink").href = "TeacherLogin.jsp";
				document.getElementById("registerLink").href = "TeacherRegister.jsp";
			}
		}

		function goBack() {
			document.getElementById("actionSelection").style.display = "none";
			document.getElementById("roleSelection").style.display = "block";
		}
	</script>
<jsp:include page="footer.jsp"/>
</body>
</html>