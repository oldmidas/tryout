<%@page import="todo.UserVO"%>
<%@page import="todo.TodoDAO"%>
<%@page import="todo.TodoVO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	
	HttpSession session = request.getSession(false);
	if (session == null) {
		response.sendRedirect("main.jsp?err=deny");
		return;
	}
	UserVO user = (UserVO) session.getAttribute("LOGIN_USER");
	if (user == null) {
		response.sendRedirect("main.jsp?err=deny");
		return;
	}
	
	String category = request.getParameter("category");
	String title = request.getParameter("title");
	String description = request.getParameter("description");
	String location = request.getParameter("location");
	String day = request.getParameter("day");
	String isCompleted = request.getParameter("isCompleted");
	
	Boolean isCompletedBoolean = false;
	
	TodoVO vo = new TodoVO();
	vo.setCatagory(category);
	vo.setTitle(title);
	vo.setDescription(description);
	vo.setLocation(location);
	vo.setDay(day);
	vo.setUserId(user.getId());
	if ("complete".equals(isCompleted)) {
		isCompletedBoolean = true;
	}
	vo.setCompleted(isCompletedBoolean);
	
	TodoDAO dao = new TodoDAO();
	dao.addTodo(vo);
	response.sendRedirect("index_2.jsp?pno=1");
%>