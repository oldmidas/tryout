<%@page import="todo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	// 세션아이디에 해당하는 세션객체를 검색
	HttpSession session = request.getSession(false);
	
	if (session == null) {
		response.sendRedirect("main.jsp?err=fail");
		return;
	}
	
	// 세션 객체에서 "LOGIN_USER"라는 이름으로 저장된 객체찾기
	UserVO user = (UserVO) session.getAttribute("LOGIN_USER");
	if (user == null) {
		response.sendRedirect("main.jsp?err=fail");
		return;
	}
	
%>
<div class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a href="index.jsp" class="navbar-brand">Todo App</a>
		</div>
		<p class="navbar-text"><%=user.getName() %>님 환영합니다.</p>
		<ul class="nav navbar-nav">
			<li><a href="logoutprocess.jsp">로그아웃</a></li>
		</ul>
	</div>
</div>