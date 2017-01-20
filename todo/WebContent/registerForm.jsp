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
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">일정 등록하기</div>
					<form action="register.jsp" method="post">
						<div class="panel-body">
							<div class="form-group">
								<label>종류</label> <input type="text" class="form-control"
									name="category"/>
							</div>
							<div class="form-group">
								<label>제목</label> <input type="text" class="form-control"
									name="title" />
							</div>
							<div class="form-group">
								<label>내용</label> 
								<textarea class="form-control" rows="5" name="description"></textarea>
							</div>
							<div class="form-group">
								<label>장소</label> <input type="text" class="form-control"
									name="location"/>
							</div>
							<div class="form-group">
								<label>일시</label> <input type="date" class="form-control"
									name="day" />
							</div>
							<div class="form-group">
								<label>완료 여부</label>
								<div class="radio">
									<label><input type="radio" name="isCompleted" value="complete" disabled>완료(Y)</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="isCompleted" value="incomplete">미완료(N)</label>
								</div>
							</div>
						</div>
						<div class="panel-footer text-right">
							<input type="submit" class="btn btn-success" value="등록" /> 
							<a href="index.jsp"><input type="button" class="btn btn-danger" value="취소" /></a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>