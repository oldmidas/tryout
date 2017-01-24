<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<link rel="stylesheet" type="text/css" href="css/header.css">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">MoBet</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">커뮤니티 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">공지사항</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">배팅 토론</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">자유게시판</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">해외축구</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">국내야구</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">MLB</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">NBA</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">국내축구</a></li>

					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">모의 배팅 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">배팅하기</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">배팅결과</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">유저랭킹 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">유저순위</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">쪽집게 추천</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Contact Us<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">광고문의</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">기타문의</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">포인트:300p</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><span class="glyphicon glyphicon-user"
						aria-hidden="true"></span> 안녕<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="http://www.fgruber.ch/" target="_blank"><span
								class="glyphicon glyphicon-cog" aria-hidden="true"></span> 정보수정</a></li>
						<li><a href="/logout"><span
								class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
								로그아웃</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>