<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />   
<script src="js/parseMd.js"></script>
<style>
#titleDiv{
	width: 140px;
	padding: 10px;
	color: #26469B;
	background-color : white;
	font-size: 25px;
	text-align: center;
	font-weight: bold;
	margin-left: 55px;
}

</style> 
</head>
<body>
    <div>
    	<br><br><div style="margin-left: 85px;font-size: 1.2em"><b><c:out value="${param.search}" /></b>&nbsp;을/를 포함한 검색 결과</div>
		<br><div id='titleDiv'>모집 글</div>
		<hr style="margin-left: 80px; width: 80%;">
        <c:forEach items="${MboardList}" var="Mboard">
        	<div style="width:80%; margin-left: 100px" id='md_content_${Mboard.seq}'></div>
        	<c:if test="${Mboard.writerid eq sessionScope.id}">
        		<form action="deleteMboard.do?seq=${Mboard.seq}" method="post">
        			<input type="submit" value="삭제하기" id="formBtn" style="border:none; width: 70px; height: 30px;
        			background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:960px"/>
        		</form>    		
        	</c:if>
    		<hr style="margin-left: 80px; width: 80%">
		</c:forEach>
		<script>
			<c:forEach items="${MboardList}" var="Mboard">
				var mdContent = '${Mboard.content}'; 
	        	var parsedHtml = parseMd(mdContent); 
	        	document.getElementById('md_content_${Mboard.seq}').innerHTML = parsedHtml;
    		</c:forEach>
        </script>
        
        <br><div id='titleDiv'>신청 글</div>
        <hr style="margin-left: 80px; width: 80%;">
        <c:forEach items="${SboardList}" var="Sboard">
        	<div style="width:80%; margin-left: 100px" id='md_content_${Sboard.seq}'></div>
        	<c:if test="${Sboard.writerid eq sessionScope.id}">
        		<form action="deleteSboard.do?seq=${Sboard.seq}" method="post">
        			<input type="submit" value="삭제하기" id="formBtn" style="border:none; width: 70px; height: 30px;
        			background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:960px"/>
        		</form>    		
        	</c:if>
    		<hr style="margin-left: 80px; width: 80%">
		</c:forEach>
		<script>
			<c:forEach items="${SboardList}" var="Sboard">
				var mdContent = '${Sboard.content}'; 
	        	var parsedHtml = parseMd(mdContent); 
	        	document.getElementById('md_content_${Sboard.seq}').innerHTML = parsedHtml;
    		</c:forEach>
    		console.log(${searchValue})
    		console.log('hi')
    		console.log(${search})
        </script>

    </div>
 	

</body>
</html>
