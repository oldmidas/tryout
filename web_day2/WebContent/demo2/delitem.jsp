<%@page import="demo2VO.UserVO"%>
<%@page import="demo2DAO.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@include file="logincheck.jsp" %>
<%
	ItemDAO dao = new ItemDAO();
	dao.delItemByCartNo(Integer.parseInt(request.getParameter("cno")));
	response.sendRedirect("cart.jsp");
	return;
%>