<%@page import="util.NumberUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="todo.TodoDAO"%>
<%@page import="todo.TodoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="container">
		<div class="col-sm-10">
			<div class="panel panel-default">
				<div class="panel-heading">일정 목록</div>
				<div class="panel-body">
					<table class="table">
						<colgroup>
							<col width="50%">
							<col width="20%">
							<col width="10%">
							<col width="20%">
						</colgroup>
						<thead>
							<tr>
								<th>제목</th>
								<th>날짜</th>
								<th>완료 여부</th>
								<th></th>
							</tr>
						<%
							HttpSession curSession = request.getSession();
							UserVO curUser = (UserVO) curSession.getAttribute("LOGIN_USER");
							String userId = curUser.getId();
							TodoDAO curTodoDao = new TodoDAO();
							ArrayList<TodoVO> todos = new ArrayList<>();
							todos = curTodoDao.showAllTodo(userId);
						%>
						</thead>
						<tbody>						
							<% 
								final int ROWS_PER_PAGE = 10;
								TodoDAO todoDao = new TodoDAO();
								
								// 내가 등록한 총 게시글 개수
								int totalRows = todoDao.getTotalRows(user.getId());
								
								// 총 페이지 개수 계산하기
								int totalPages = (int) Math.ceil((double)totalRows/ROWS_PER_PAGE);
								
								// 페이지 번호 알아내기
								//int pageNo = Integer.parseInt(request.getParameter("pno"));
								int pageNo = NumberUtil.StringToInt(request.getParameter("pno"), 1, totalRows);
								
								// 조회시, 구간 시작 값과 구간 끝 값 알아내기
								int beginIndex = (pageNo - 1) * ROWS_PER_PAGE + 1;
								int endIndex = pageNo * ROWS_PER_PAGE;
								
								// 요청한 페이지에 해당하는 일정 조회하기
								ArrayList<TodoVO> todoList = todoDao.getTodoListForPaging(beginIndex, endIndex, userId);
								
								
								
								for (TodoVO todo : todoList) {
										String isCompletedString = "";
										if (todo.isCompleted()) {
											isCompletedString = "Y";
										} else if (!todo.isCompleted()) {
											isCompletedString = "N";
										}
										
								%>						
											<tr>
												<td><a href="detail.jsp?tno=<%=todo.getNo()%>&pno=<%=pageNo%>"><%=todo.getTitle() %></a></td>
												<td><%=todo.getDay() %></td>
												<td><%=isCompletedString%></td>
												<th>
												<% if ("Y".equals(isCompletedString)) { %>
													<div class="col-md-5">
														<a href="" class="btn btn-info">완료</a>
													</div>
													<div class="col-md-2"></div>
													<div class="col-md-5">
														<a href="delete.jsp?tno=<%=todo.getNo() %>" class="btn btn-danger">삭제</a>
													</div>
													<% } else if ("N".equals(isCompletedString)) { %>
													<div class="col-md-5">
														<a href="complete.jsp?tno=<%=todo.getNo()%>&pno=<%=pageNo%>" class="btn btn-success">완료</a>
													</div>
													<div class="col-md-2"></div>
													<div class="col-md-5">
														<a href="delete.jsp?tno=<%=todo.getNo()%>&pno=<%=pageNo%>" class="btn btn-danger">삭제</a>
													</div>
													<% } %>				
												</th>	
											</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<div>
						<div class="panel-footer text-center">
							<ul class="pagination">
								<%for (int index=1; index<=totalPages; index++) { 
									if (pageNo == index) {
									
								%>
									<li class="active"><a href=""><%=index %></a></li>
								<% } else if (!(pageNo == index )) {  %>										
									<li><a href="index_2.jsp?pno=<%=index %>"><%=index %></a></li>
								<% }
								
								} %>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel-footer text-right">
					<form action="registerForm.jsp">
						<button class="btn btn-default">새 일정 등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>