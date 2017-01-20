<%@page import="todo.MD5"%>
<%@page import="todo.UserVO"%>
<%@page import="todo.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<% 
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	
	UserDAO userDao = new UserDAO();
	UserVO user = userDao.getUserById(userid);
	
	if (user == null) {
		response.sendRedirect("main.jsp?err=fail");
		return;		
	}
	
	String securityPassword = MD5.hash(userpwd);
	
	if (!securityPassword.equals(user.getPwd())) {
		response.sendRedirect("main.jsp?err=fail");
		return;				
	}
	
	// 사용자정보도 존재하고, 비밀번호도 일치하는 경우에만 이 부분이 실행된다.
	HttpSession session = request.getSession(true);
	session.setAttribute("LOGIN_USER", user);
	
	response.sendRedirect("index_2.jsp?pno=1");
%>