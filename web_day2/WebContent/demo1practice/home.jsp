<%@page import="demo1practice.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="demo1practice.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	p {
		font-size:50px;
	}
</style>
</head>
	<body>
		<img src="http://cfile24.uf.tistory.com/image/243ABB375638616324A839"/>
		<p>게시판</p>
			<form action="http://freefeast.info/wp-content/uploads//2012/06/freefeast_gosling.jpg" display="inline">
				<button>제임스 고슬링!</button>
			</form>
		<table width="100%" border="1">
			<tr>
				<td>번호</td><td>제목</td><td>작성자</td><br/>
				<%
				BoardDAO dao = new BoardDAO();
				ArrayList<BoardVO> boards = dao.showAllList();
				for (BoardVO board : boards) {
					int no = board.getNo();
					String title = board.getTitle();
					String writer = board.getWriter();
					%>
			<tr>
				<td><%=no %></td><td><a href="viewBoardDetail.jsp?bno=<%=no%>"><%=title %></a></td><td><%=writer %></td><br/>
					<%
				}
				%>
		</table>
		
		<br/>
		<div>
			<form action="newBoard.jsp" display="inline">
				<button>글쓰기</button>
			</form><br/>
		</div>
	</body>
</html>