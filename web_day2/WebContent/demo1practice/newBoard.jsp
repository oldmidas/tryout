<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="addNewBoard.jsp">
		<h2>글쓴이</h2><br/>
		<input type="text" name="writer"><br/>
		<h2>제목</h2><br/>
		<input type="text" name="title"><br/>
		<h2>내용</h2><br/>
		<textarea rows="5" cols="30" name="contents"></textarea><br/>
		<input type="submit">
	</form>
</body>
</html>