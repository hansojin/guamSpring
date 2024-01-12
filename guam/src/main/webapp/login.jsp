<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
<c:if test="${sessionScope.loginError == true}">
	<script>
		alert('잘못된 정보입니다.');
		<c:remove var="loginError" scope="session" />
	</script>
</c:if>
</head>
<body>
	<div class='formCss'>
	<h3>로그인</h3>
	<form action="login.do" method="post" >
		<table>
			<tr>
				<td>아이디</td><td><input type="text" name="id" value="${user.id}" /></td>
			</tr>
			<tr>
				<td>비밀번호</td><td><input type="password" name="password" value="${user.password}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인" id="formBtn"/></td>
			</tr>
			
		</table>
	</form>
	<p>GUAM 회원이 아니세요?&nbsp;&nbsp;&nbsp;&nbsp;<a href="memberRegister.jsp">회원가입</a></p>
	</div>
</body>
</html>