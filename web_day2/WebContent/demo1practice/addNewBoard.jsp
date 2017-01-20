<%@page import="demo1practice.BoardDAO"%>
<%@page import="demo1practice.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	BoardVO board = new BoardVO();
	board.setWriter(writer);
	board.setTitle(title);
	board.setContents(contents);
	
	BoardDAO dao = new BoardDAO();
	dao.addNewBoard(board);
	
	response.sendRedirect("home.jsp");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>