<%@page import="todo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	HttpSession session = request.getSession(false);
	if (session == null) {
		response.sendRedirect("main.jsp");
		return;
	}
	
	UserVO currUser = (UserVO) request.getAttribute("LOGIN_USER");
	if (currUser == null) {
		response.sendRedirect("main.jsp");
		return;
	}
	
	session.invalidate();
	response.sendRedirect("main.jsp");

%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>