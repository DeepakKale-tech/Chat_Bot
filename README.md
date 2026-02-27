🎓 Student–Teacher Chat Application

A role-based chat application built using Java Servlets, JSP, JDBC, and MySQL.
This system enables real-time style communication between Students and Teachers using HTTP-based AJAX polling.

📌 Project Overview
This project allows:

	Students to chat with Teachers
	
	Teachers to chat with Students
	
	Messages to be stored in a MySQL database
	
	Role-based session handling
	
	Dynamic sender identification (Student/Teacher with name)
	
	The system ensures proper message ownership even when IDs overlap between different tables.

🏗️ Technologies Used

	Java (JDK 17+ recommended)
	
	Jakarta Servlet API
	
	JSP
	
	JDBC
	
	MySQL
	
	Apache Tomcat Server
	
	HTML, CSS, JavaScript (AJAX)
	
🧠 Communication Type

This project uses:

HTTP Request–Response Model with AJAX Polling

It is NOT WebSocket-based.

The browser periodically sends AJAX requests to fetch new messages from the server.

Flow:
	Browser → Servlet → Database → Servlet → Browser
	
🗄️ Database Structure
student table
	sid (Primary Key)
	sname
	email
	password

teacher table
	tid (Primary Key)
	tname
	email
	password
	
messages table
	id (Primary Key)
	sender_id
	sender_role
	receiver_id
	receiver_role
	message
	timestamp
	
🔐 Session Handling

After login, the system stores:
	userId
	role
	name

in the HttpSession.

These session attributes are used to:

	Identify sender
	
	Determine receiver role
	
	Fetch correct chat messages
	
✨ Features

Role-based login (Student / Teacher)

Dynamic message display:
	STUDENT: Nayan - Good Morning
	TEACHER: Deepak K1 - Hello
	
Secure session validation

Database-driven message storage

Proper sender/receiver filtering

Clean servlet architecture

🚀 How to Run

Clone the repository

Import project into Eclipse / IntelliJ

Configure MySQL database

Update DB credentials in:
	DBConnection.java
	
Deploy on Apache Tomcat

Run application

👨‍💻 Author

Deepak Kale

📄 License

This project is for educational purposes.