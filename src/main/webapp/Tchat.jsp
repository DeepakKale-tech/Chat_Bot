<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Integer senderId = (Integer) session.getAttribute("userId");
String receiverId = request.getParameter("receiverId");
%>
Sender:
<%=senderId%>
Receiver:
<%=receiverId%>
<!DOCTYPE html>
<html>
<head>
<title>Live Chat</title>
<script>

function sendMessage() {
    var text = document.getElementById("msg").value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "SendMessageServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.send("senderId=<%=senderId%>&receiverId=<%=receiverId%>&text="+ text);

		document.getElementById("msg").value = "";
	}

	function loadMessages() {
		var xhr = new XMLHttpRequest();
		 xhr.open("GET", "GetMessageServlet?senderId=<%=senderId%>&receiverId=<%=receiverId%>", true);

		xhr.onload = function() {
			document.getElementById("chatBox").innerHTML = this.responseText;
		};

		xhr.send();
	}

	setInterval(loadMessages, 1000); // refresh every second
</script>
</head>

<body>
	<h2>Techer Chat</h2>

	<div id="chatBox"
		style="border: 1px solid black; height: 200px; overflow: auto;"></div>

	<input type="text" id="msg">
	<button onclick="sendMessage()">Send</button>

</body>
</html>