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
<style>

div {
	border: 0px solid black;
}

</style>
</head>
<body>
	<%@include file="/common/nav.jsp"%>
	<div class="container">
		<div class="row" style="padding-bottom: 20px">
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">Low-Level Languages</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">C <span class="badge">12</span></li>
							<li class="list-group-item">Assembly <span class="badge">5</span></li>
							<li class="list-group-item">PHP <span class="badge">10</span></li>
							<li class="list-group-item">ETC <span class="badge">7</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">High-Level Languages</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">Java <span class="badge">120</span></li>
							<li class="list-group-item">Javascript <span class="badge">151</span></li>
							<li class="list-group-item">Python <span class="badge">96</span></li>
							<li class="list-group-item">ETC <span class="badge">136</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="padding-bottom: 20px">
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">DateBase</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">SQL <span class="badge">68</span></li>
							<li class="list-group-item">MySQL <span class="badge">88</span></li>
							<li class="list-group-item">Node.js <span class="badge">91</span></li>
							<li class="list-group-item">ETC <span class="badge">16</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">Server/Network</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">Server <span class="badge">12</span></li>
							<li class="list-group-item">Network <span class="badge">5</span></li>
							<li class="list-group-item">Thread <span class="badge">5</span></li>
							<li class="list-group-item">ETC <span class="badge">16</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="padding-bottom: 20px">
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">Versus</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">Human vs A.I. <span class="badge">12</span></li>
							<li class="list-group-item">Sports <span class="badge">59</span></li>
							<li class="list-group-item">Food <span class="badge">3</span></li>
							<li class="list-group-item">Politic <span class="badge">3</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">Work/Job</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">Company <span class="badge">231</span></li>
							<li class="list-group-item">Job <span class="badge">150</span></li>
							<li class="list-group-item">Boss <span class="badge">71</span></li>
							<li class="list-group-item">Looking for Co-Founder <span class="badge">3</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="padding-bottom: 20px">
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">FreeBoard</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">Car <span class="badge">12</span></li>
							<li class="list-group-item">Girl <span class="badge">3</span></li>
							<li class="list-group-item">Game <span class="badge">5</span></li>
							<li class="list-group-item">ETC <span class="badge">3</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">Job Opening</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">FullTime <span class="badge">12</span></li>
							<li class="list-group-item">PartTime <span class="badge">3</span></li>
							<li class="list-group-item">Contract <span class="badge">5</span></li>
							<li class="list-group-item">Lunar <span class="badge">3</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/common/footer.jsp"%>
</body>
</html>