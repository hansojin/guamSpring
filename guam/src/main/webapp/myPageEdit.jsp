<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
</head>
<body>
	<div class='formCss'>
	<h3>회원가입</h3>
	<form action="updateMemberInfo.do?id=${sessionScope.id}">
		<table>
			<tr>
				<td><label for="id">아이디</label></td><td><input type="text" name="id" id="id" value="${user.id}" readonly/>
			</tr>
			<tr>
				<td><label for="password">비밀번호</label></td><td><input type="password" name="password" id="password" value="${user.password}"/>
			</tr>
			<tr>
				<td><label for="name">이름</label></td><td><input type="text" name="name" id="name" value="${user.name}"/>
			</tr>
			<tr>
				<td><label for="company">소속</label></td><td><input type="text" name="company" id="company" value="${user.company}"/>
			</tr>
			<tr>
				<td><label for="github">깃헙</label></td><td><input type="text" name="github" id="github" value="${user.github}"/>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정하기" id="formBtn"/></td>
			</tr>
		</table>
	</form>
	
	</div>	
</body>
</html>