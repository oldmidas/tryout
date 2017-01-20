<%@page import="todo.TodoVO"%>
<%@page import="todo.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	TodoDAO dao = new TodoDAO();
	int tno = Integer.parseInt(request.getParameter("tno"));
	TodoVO vo = dao.showDetailByNo(tno);
	String isCompletedString = "";
	
	if (vo.isCompleted()) {
		isCompletedString = "처리완료";
	} else if (!vo.isCompleted()) {
		isCompletedString = "처리중";
	}
	
	int pno = Integer.parseInt(request.getParameter("pno"));

%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	
</script>
<title>상세 보기</title>
</head>
<body>
	<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a href="index.jsp" class="navbar-brand">Todo App</a>
			</div>
		</div>
	</div>
	<div class="container col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">일정 상세정보</div>
			<div class="panel-body">
				<table class="table table-striped">
					<colgroup>
						<col width="15%">
						<col width="85%">
					</colgroup>
					<tbody>
						<tr>
							<th>종류</th><td><%=vo.getCatagory() %></td>
						</tr>
						<tr>
							<th>제목</th><td><%=vo.getTitle() %></td>
						</tr>
						<tr>
							<th>내용</th><td><textarea rows="5" class="form-control" readonly="readonly"><%=vo.getDescription() %></textarea></td>
						</tr>
						<tr>
							<th>장소</th><td><%=vo.getLocation() %></td>
						</tr>
						<tr>
							<th>일시</th><td><%=vo.getDay() %></td>
						</tr>
						<tr>
							<th>처리여부</th><td>
							<% if (vo.isCompleted()) { %>
								<button class="btn btn-primary"><%=isCompletedString %></button></td>
							<% } else if (!vo.isCompleted()) { %>
								<button class="btn btn-warning"><%=isCompletedString %></button></td>							
							<% } %>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer text-right">
				<a href="index_2.jsp?pno=<%=pno%>" class="btn btn-default">목록보기</a>
			</div>
		</div>
	</div>
</body>
</html>