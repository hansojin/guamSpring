<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <title>My Banner</title> -->
<link rel="stylesheet" href="path/to/bootstrap.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="css/banner.css">


<!-- </head> -->
<!-- <body> -->
<div class='banner'>
	<nav class="navbar navbar-expand-lg navbar-light  ">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> 🔍<span id='logo'>괌</span>🔎
			</a>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto">
					<li class="nav-item">
						<a class="nav-link" href="getMboardList.do">모집</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="getSboardList.do">신청</a></li>
					<li class="nav-item">
						<a class="nav-link" href="/Study">스터디</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="communityList.do">커뮤니티</a>
					</li>
					<li class="nav-item">
						<c:choose>
							<c:when test="${empty sessionScope.id}">
								<a class="nav-link" href="login.jsp">마이페이지</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="getUserInfo.do?id=${sessionScope.id}">마이페이지</a>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>

				<nav class="navbar navbar-light navbar-sm">
					<div class="container-fluid">
						<form class="d-flex" action="searchBoardList.do">
							<input class="form-control me-2" type="search" placeholder="Search" id="search" name="search">
							<button class="btn btn-outline-primary" type="submit">Search</button>
						</form>
					</div>
				</nav>

				<div class='login'>
					<c:choose>
						<c:when test="${not empty sessionScope.id}">
							<a class="nav-link" href="logout.do"
								style="font-family: 'DNFBitBitv2'; font-size: 1.1em">로그아웃</a>
						</c:when>
						<c:otherwise>
							<a class="nav-link" href="login.jsp"
								style="font-family: 'DNFBitBitv2'; font-size: 1.1em">로그인</a>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</div>
	</nav>
</div>
<!-- </body> -->
<!-- </html> -->
