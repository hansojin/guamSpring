<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
</head>
<body>
	<br><br>
	<div style="width:78%; margin : 30px 130px">
		<h4>게시물 수정하기</h4>
		<hr style="margin-bottom: 25px; margin-top: 25px;" />
        <c:choose>
                <c:when test="${commList.cate eq 'free'}">
                    <p style="color: #C17BB6;">[ <b>자유</b> ]</p>
                </c:when>
                <c:when test="${commList.cate eq 'job'}">
                    <p style="color: #FFBC5C;">[ <b>진로</b> ]</p>
                </c:when>
                <c:when test="${commList.cate eq 'qna'}">
                    <p style="color: #E4598B;">[ <b>질문</b> ]</p>
                </c:when>
        </c:choose>
        <form action="editPost.do?seq=${commList.seq}" method="post" >
        	<b>제&nbsp;목&nbsp;</b>
        	<input type='text' value="${commList.title}" style="width:89%" id="title" name="title"><br>
        	<b>내&nbsp;용</b><br>
        	<textarea rows="15" cols="90" style="margin-left:40px;" id='content' name='content'>${commList.content}</textarea><br><br>
        	<input type="submit" value="수정하기" style="width:140px; padding:10px; background-color: #26469B; color: white;
        	border: none; border-radius: 4px;fontSize: 16px;cursor: pointer; margin-left: 390px"/>
 		</form>
        <hr style="margin-bottom: 25px; margin-top: 25px;" />
    </div><br><br><br>
    <p style='text-align: center'>&copy; 2024 GUAM</p>
</body>
</html>