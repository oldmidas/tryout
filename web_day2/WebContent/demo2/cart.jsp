<%@page import="java.util.Date"%>
<%@page import="demo2VO.ItemVO"%>
<%@page import="demo2VO.CartVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="demo2DAO.ItemDAO"%>
<%@page import="demo2VO.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		// 로그인한 사람의 정보 차지
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("loginform.jsp?err=deny");
			return;
		}
		// session에서 사용자 정보가 저장된 객체 가져오기
		UserVO user = (UserVO) session.getAttribute("LOGINED_USER");
		if (user == null) {
			response.sendRedirect("loginform.jsp?err=deny");
			return;
		}
		
		ItemDAO dao = new ItemDAO();
		ArrayList<CartVO> cartItems = dao.getCartItemsByUser(user.getId());
	%>

<div class="container">
	<h1>장바구니</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>제품명</th><th>제조사</th><th>가격</th><th>등록일</th><th></th>
			</tr>
		</thead>
		<tbody>
	<%
		if (!cartItems.isEmpty()) {
			for (CartVO cart : cartItems) {
				ItemVO item = cart.getItem();
				String name = item.getName();
				String maker = item.getMaker();
				int price = item.getPrice();
				Date regdate = cart.getRegdate();
	%>		
		<tr>
			<th><%=name %></th><th><%=maker %></th><th><%=price %></th><th><%=regdate %></th><th><a href="delitem.jsp?cno=<%=cart.getNo() %>">삭제</th>
		</tr>
	<%	
			}
		} else {
	%>
		<tr>
			<th colspan="4" class="text-center"><strong>장바구니에 저장된 상품이 없습니다.</strong></th>
		</tr>
	<%	
		}
	%>
		</tbody>
	</table>
	<p class="text-right">
		<a href="items.jsp">쇼핑 계속하기</a>
	</p>
</div>

</body>
</html>