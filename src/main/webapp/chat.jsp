<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer senderId = (Integer) session.getAttribute("userId");
String receiverId = request.getParameter("receiverId");

if(senderId == null){
    response.sendRedirect("StudentLogin.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Live Chat</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.chat-container {
    width: 600px;
    height: 80vh;
    background: white;
    border-radius: 15px;
    display: flex;
    flex-direction: column;
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
    overflow: hidden;
}

.chat-header {
    background: #4e73df;
    color: white;
    padding: 15px;
    font-weight: bold;
}

.chat-box {
    flex: 1;
    padding: 15px;
    overflow-y: auto;
    background: #f8f9fa;
}

.chat-input {
    padding: 10px;
    border-top: 1px solid #ddd;
    background: #fff;
}

.message {
    margin-bottom: 10px;
    padding: 8px 12px;
    border-radius: 15px;
    max-width: 70%;
    word-wrap: break-word;
}

.sender {
    background: #4e73df;
    color: white;
    margin-left: auto;
}

.receiver {
    background: #e9ecef;
    color: black;
}
</style>

<script>

function sendMessage() {
    var text = document.getElementById("msg").value;

    if(text.trim() === "") return;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "SendMessageServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.send("senderId=<%=senderId%>&receiverId=<%=receiverId%>&text=" + encodeURIComponent(text));

    document.getElementById("msg").value = "";
}

function loadMessages() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "GetMessageServlet?senderId=<%=senderId%>&receiverId=<%=receiverId%>", true);

    xhr.onload = function() {
        document.getElementById("chatBox").innerHTML = this.responseText;
        document.getElementById("chatBox").scrollTop = document.getElementById("chatBox").scrollHeight;
    };

    xhr.send();
}

setInterval(loadMessages, 1000);

//Send message when pressing Enter
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("msg").addEventListener("keypress", function(e) {
        if(e.key === "Enter") {
            sendMessage();
        }
    });
});

</script>

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="chat-container">

    <div class="chat-header d-flex justify-content-between align-items-center">
        <span>Student Live Chat</span>
        <a href="StudentDashboard.jsp" class="btn btn-sm btn-light">Back</a>
    </div>

    <div id="chatBox" class="chat-box">
        <!-- Messages will load here -->
    </div>

    <div class="chat-input">
        <div class="input-group">
            <input type="text" id="msg" class="form-control" placeholder="Type your message...">
            <button class="btn btn-primary" onclick="sendMessage()">Send</button>
        </div>
    </div>

</div>

<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>