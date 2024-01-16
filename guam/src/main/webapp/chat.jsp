<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="banner.jsp" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:set var="dateTimeFormatter" value="HH:mm" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
<style>
	#chat{
		margin-left:18%;
		border:1px solid #26469B;
		height:480px;
		width: 60%;
		border-radius: 4px;
		padding:5px;
	}
</style>
</head>
<body>
	<div>
		<div style='margin-left:18%;margin-top:50px'>
			<h4>CHAT</h4>
			<hr style="width:74%">
		</div>
		<div id='chat'>
			<c:forEach items="${chatList}" var="chat">
				<c:choose>
    			<c:when test="${chat.writerid eq sessionScope.id}">
    				<div style='float: right; clear: both;'>
    					<span style='font-size:0.5em; color:gray'><fmt:formatDate value="${chat.regDate}" pattern="${dateTimeFormatter}" /></span>
						<span style='margin-right:10px;'>${chat.content}</span>
    				</div>
        			
    			</c:when>
    			<c:otherwise>
    				<div style='float: left; clear: both;'>
        				<span style='margin-left:5px'><b>${chat.writerid} : </b></span>
						<span style='margin-left:10px;'>${chat.content}</span>
						<span style='margin-left:10px; font-size:0.5em; color:gray'><fmt:formatDate value="${chat.regDate}" pattern="${dateTimeFormatter}" /></span>
    				</div>
    			</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<br><div style='margin-left:18%;'>
			<form action="chatInsert.do" method='POST'>
    			<input type="text" id="content" name="content" style='width:65%; padding:8px;border:1px solid #26469B;border-radius: 4px;'>
    			<input type="hidden" id="seq" name="seq" value="${param.seq}">
    			<input type="hidden" id="writerid" name="writerid" value="${sessionScope.id}">
    			<input type='submit' value="입력" style="padding:8px;border:1px solid #26469B;border-radius: 4px;background-color: white;width:80px">
			</form>
		</div>
	</div>
	<p style='text-align: center; position: absolute; bottom: 10; left: 50%; transform: translateX(-50%);'>&copy; 2024 GUAM</p><br>
	<script>
    function reloadPage() {
        var isContentFocused = document.activeElement && document.activeElement.id === 'content';
        if (!isContentFocused) {
            window.location.href = "toChat.do?seq=${param.seq}";
        	}
    	}
    	setInterval(reloadPage, 2000);
	</script>
</body>
</html>