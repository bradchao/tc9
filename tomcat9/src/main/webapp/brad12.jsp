<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("user");
    if (username == null) {
        // 如果沒有登入，重定向到登入頁面
        response.sendRedirect("brad11.html");
    }
%>
<h1>Welcome, <%= username %>!</h1>
<a href="logout.jsp">Logout</a>
</body>
</html>