<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<style>
.image-link {
	cursor: pointer; 
}
img{
	width:100%;
}
</style>
<script>
function navigateTo(url) {
    window.location.href = url;
}
</script>
<body>
	
	<img src="img/main.PNG" alt="구함"><br>
	<img src="img/sub1.PNG" alt="모집" onclick="navigateTo('getMboardList.do')" class="image-link"><br>
    <img src="img/sub2.PNG" alt="신청" onclick="navigateTo('getSboardList.do')" class="image-link"><br>
    <img src="img/sub3.PNG" alt="스터디" onclick="navigateTo('memberRegister.jsp')" class="image-link"><br>
    <img src="img/sub4.PNG" alt="커뮤니티" onclick="navigateTo('memberRegister.jsp')" class="image-link"><br>
	
	<%@ include file="footer.jsp" %>
</body>

</html>