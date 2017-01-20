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
<title></title>
<!-- 
<style>
	.container {
		margin-top : 100px
	}
</style>
-->
</head>
<body>
	<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a href="main.jsp" class="navbar-brand">Todo App</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">일정 관리 프로그램</div>
					<form action="loginprocess.jsp" method="post">
						<div class="panel-body">
							<div class="form-group">
								<label for="userid">아이디</label> <input type="text"
									class="form-control" name="userid">
							</div>
							<div class="form-group">
								<label for="userpwd">비밀번호</label> <input type="password"
									class="form-control" name="userpwd">
							</div>
						</div>
							<div class="panel-footer text-right">
								<button class="btn btn-primary">로그인</button>
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>