<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello, JSP!</title>
</head>
<body>
	<h1>JSP 페이지 연습</h1>
	<%
		String name = "홍길동";
		String phone = "010-1234-5678";
	%>
	<p>이름:<%=name %></p>
	<p>연락처:<%=phone %></p>
</body>
</html>