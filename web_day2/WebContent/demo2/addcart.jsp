<%@page import="demo2DAO.ItemDAO"%>
<%@page import="demo2VO.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	HttpSession session = request.getSession(false);
	if (session == null) {
		response.sendRedirect("loginform.jsp?err=deny");
		return;
	}
	
	UserVO user = (UserVO) session.getAttribute("LOGINED_USER");
	if (user == null) {
		response.sendRedirect("loginform.jsp?err=deny");
		return;
	}
	
	// user가 null이 아닌 상황이기 때문에, HttpSession에서 꺼낸 UserVO객체에서
	// 로그인한 사용자의 아이디를 가져올 수 있다.
	String userId = user.getId();
	int itemNo = Integer.parseInt(request.getParameter("ino"));
	ItemDAO dao = new ItemDAO();
	dao.addCart(itemNo, userId);
	
	// 장바구니 목록 페이지를 다시 요청하게 하기
	response.sendRedirect("cart.jsp");
	
%>