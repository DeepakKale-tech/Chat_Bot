<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #667eea, #764ba2);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .register-card {
        width: 420px;
        border-radius: 15px;
        padding: 30px;
    }

    .password-wrapper {
        position: relative;
    }

    .toggle-password {
        position: absolute;
        top: 50%;
        right: 15px;
        transform: translateY(-50%);
        cursor: pointer;
        color: #6c757d;
    }
</style>

</head>
<body>

<div class="card shadow-lg register-card">

    <div class="text-center mb-4">
        <h3 class="fw-bold">Student Registration</h3>
        <p class="text-muted">Create your account to start chatting</p>
    </div>

    <form action="StudentReg" method="post">

        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text"
                   class="form-control"
                   name="sname"
                   placeholder="Enter full name"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email"
                   class="form-control"
                   name="smail"
                   placeholder="Enter email"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text"
                   class="form-control"
                   name="suser"
                   placeholder="Choose username"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>

            <div class="password-wrapper">
                <input type="password"
                       class="form-control"
                       name="spass"
                       id="password"
                       placeholder="Create password"
                       required>

                <i class="bi bi-eye-slash toggle-password"
                   id="toggleIcon"
                   onclick="togglePassword()"></i>
            </div>
        </div>

        <div class="d-grid mb-3">
            <button type="submit" class="btn btn-success">
                Register
            </button>
        </div>

        <div class="d-grid">
            <a href="index.jsp" class="btn btn-outline-secondary">
                Return Home
            </a>
        </div>

    </form>

    <div class="text-center mt-3">
        <small class="text-muted">
            Already have an account? <a href="StudentLogin.jsp">Login</a>
        </small>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="js/bootstrap.bundle.min.js"></script>

<script>
function togglePassword() {
    const password = document.getElementById("password");
    const icon = document.getElementById("toggleIcon");

    if (password.type === "password") {
        password.type = "text";
        icon.classList.remove("bi-eye-slash");
        icon.classList.add("bi-eye");
    } else {
        password.type = "password";
        icon.classList.remove("bi-eye");
        icon.classList.add("bi-eye-slash");
    }
}
</script>
<jsp:include page="footer.jsp"/>
</body>
</html>