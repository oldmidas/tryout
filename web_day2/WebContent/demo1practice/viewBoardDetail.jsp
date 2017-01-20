<%@page import="demo1practice.BoardDAO"%>
<%@page import="demo1practice.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.viewBoardDetail(Integer.parseInt(request.getParameter("bno")));
	
	int no = board.getNo();
	String title = board.getTitle();
	String writer = board.getWriter();
	String contents = board.getContents();
%>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 번호 : <%=no %></title>
</head>
<img src="http://cfile24.uf.tistory.com/image/243ABB375638616324A839"/>
<body>
	<h1>제목 : <%=title %></h1>
	<h2>글번호 : <%=no %></h2>
	<h2>작성자 : <%=writer %></h2>
	<h3>글내용 : <%=contents %></h3>
<form action="home.jsp">
<button>돌아가기</button>
<h3><a href="delete.jsp?bno=<%=no%>">삭제하기</a></h3>
</form>
</body>
</html>