<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String name = (String) session.getAttribute("name");
String role = (String) session.getAttribute("role");
%>

<style>
.header-fixed {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    background: linear-gradient(90deg, #4e73df, #764ba2);
    color: white;
    padding: 12px 25px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 9999;
    box-shadow: 0 2px 10px rgba(0,0,0,0.15);
}

.header-title {
    font-weight: 600;
    font-size: 18px;
}

.header-right {
    display: flex;
    align-items: center;
    gap: 15px;
    font-size: 14px;
}

.logout-btn {
    background: white;
    color: #4e73df;
    padding: 5px 14px;
    border-radius: 20px;
    text-decoration: none;
    font-weight: 500;
}

.logout-btn:hover {
    background: #f2f2f2;
}

/* Prevent content hiding behind header */
body {
    padding-top: 60px;
}
</style>

<div class="header-fixed">

    <div class="header-title">
        Student-Teacher Chat
    </div>

    <% if(name != null && role != null){ %>
    <div class="header-right">
        <span><strong><%=name%></strong> (<%=role%>)</span>
        <a href="LogoutServlet" class="logout-btn">Logout</a>
    </div>
    <% } %>

</div>