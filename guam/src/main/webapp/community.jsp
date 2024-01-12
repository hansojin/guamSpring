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
#commCate{
	letter-spacing: 0.2em;
	background-color: white;
	border:none;
}
#commCate:hover {
	color: #26469B;
	font-weight: bold;
}
</style>
</head>
<body>
    <div>
    	<br><br><button id="toggleBtn">글 작성하기</button><br>

		<div id="toggleDiv" style="display: none; margin-left:250px;" >
			<hr style="width: 670px" />
			<b style="color: #8B8DB9; text-decoration: underline; font-size: 1.2em">글 작성하기</b><br><br>
			<form action="insertComm.do" method="post">
				<b>분&nbsp;류&nbsp;&nbsp;</b> 
				<select name="cate" id="cate" style="width:200px; height: 30px; text-align: center">
					<option value="free">자유</option>
					<option value="qna">질문</option>
					<option value="job">진로</option>
				</select><br><br>
				<b>제&nbsp;목&nbsp;&nbsp;</b> 
				<input type="text" name="title" id="title" style="width:600px; height: 30px;" required/><br><br>
				<b>내&nbsp;용&nbsp;&nbsp;</b><br>
				<textarea name="content" id="contentInput" style="width:650px; height: 150px;" required/></textarea><br><br>
				<input type="hidden" name="writerid" value="${sessionScope.id}" />
				<input type="submit" value="작성하기" id="submitButton" style="margin-left:250px"/>
			</form>
			<hr style="width: 670px" />
		</div>
		
		<div style="display: flex; flex-direction: column; align-items: center; padding-top: 10px;">
    		<div style="margin: 15px;">
        		<button id="commCate" onclick="redirectTo('communityList.do')">&nbsp;전체&nbsp;</button>|
        		<button id="commCate" onclick="redirectTo('communityList.do?cate=free')">자유&nbsp;</button>|
        		<button id="commCate" onclick="redirectTo('communityList.do?cate=qna')">질문&nbsp;</button>|
        		<button id="commCate" onclick="redirectTo('communityList.do?cate=job')">진로&nbsp;</button>
    		</div>
		</div><br>
		
		<div style="display: flex; flex-wrap: wrap;">
		<c:forEach items="${commList}" var="comm">
            <div id="post_${comm.seq}" onclick="redirectToPost(${comm.seq})" style="margin-left: 90px;width :25%; border-radius:20px;
            border:1px solid #AAAABC; padding:15px; margin-bottom:20px">
                <c:choose>
                    <c:when test="${comm.cate eq 'free'}"><p style="color:#C17BB6"><b>자유</b></p></c:when>
                    <c:when test="${comm.cate eq 'job'}"><p style="color:#FFBC5C"><b>진로</b></p></c:when>
                    <c:when test="${comm.cate eq 'qna'}"><p style="color:#E4598B"><b>질문</b></p></c:when>
                </c:choose>
            
                <p style="height:20px; overflow:hidden"><b>${comm.title}</b></p>
                <p style="height:150px; overflow:hidden">${comm.content}</p>
                <p>👁️${comm.view} &nbsp;💬${comm.reply}</p>
            </div>	
    	</c:forEach>
		</div>


		
		<p style='text-align: center'>&copy; 2024 GUAM</p>
    </div>
    
    <script>	

     	// 글 작성 toggle
        document.getElementById('toggleBtn').addEventListener('click', function() {
            var toggleDiv = document.getElementById('toggleDiv');
            if (toggleDiv.style.display === 'none' || toggleDiv.style.display === '') {
                toggleDiv.style.display = 'block';
            } else {
                toggleDiv.style.display = 'none';
            }
        });

        function redirectTo(url) {
            window.location.href = url;
        }
        
        function redirectToPost(seq) {
            window.location.href = 'communityPost.do?seq=' + seq;
        }
    </script>
</body>
</html>
