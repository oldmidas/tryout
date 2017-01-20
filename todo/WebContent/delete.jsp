<%@page import="todo.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	request.setCharacterEncoding("utf-8");
	int tno = Integer.parseInt(request.getParameter("tno"));
	TodoDAO dao = new TodoDAO();
	dao.deleteTodo(tno);
	response.sendRedirect("index_2.jsp?pno=1");
%>