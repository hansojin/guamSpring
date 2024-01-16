<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<style>
#studyCate{
	letter-spacing: 0.2em;
	background-color: white;
	border:none;
}
#studyCate:hover {
	color: #26469B;
	font-weight: bold;
}
</style>
</head>
<body>
    <div>
    	<br><br><button id="toggleBtn">글 작성하기</button><br>

		<div id="toggleDiv" style="display: none; margin-left:250px;" >
			<hr style="width: 880px; margin-left:-80px" /><br>
			<b style="color: #8B8DB9; text-decoration: underline; font-size: 1.2em">글 작성하기</b><br><br>
			<form action="insertStudy.do" method="post">
				<b>분&nbsp;류&nbsp;&nbsp;</b> 
				<select name="cate" id="cate" style="width:200px; height: 30px; text-align: center">
					<option value="coding">코테</option>
					<option value="interview">면접</option>
					<option value="work">취준</option>
					<option value="else">기타</option>
				</select><br><br>
				<b>제&nbsp;목&nbsp;&nbsp;</b> 
				<input type="text" name="title" id="title" style="width:600px; height: 30px;" required/><br><br>
				<b>목&nbsp;표&nbsp;&nbsp;</b><br>
				<textarea name="goal" id="goal" style="width:650px; height: 50px;" required/></textarea><br><br>
				<b>내&nbsp;용&nbsp;&nbsp;</b><br>
				<textarea name="content" id="content" style="width:650px; height: 100px;" required/></textarea><br><br>
				<input type="hidden" name="writerid" id="writerid" value="${sessionScope.id}" />
				<input type="submit" value="작성하기" id="submitButton" style="margin-left:250px"/>
			</form>
			<hr style="width: 880px; margin-left:-80px" />
		</div>
		
		
		<div style="display: flex; flex-direction: column; align-items: center; padding-top: 10px;">
    		<div style="margin: 15px;">
        		<button id="studyCate" onclick="redirectTo('studyList.do')">&nbsp;전체&nbsp;</button>|
        		<button id="studyCate" onclick="redirectTo('studyList.do?cate=coding')">코테&nbsp;</button>|
        		<button id="studyCate" onclick="redirectTo('studyList.do?cate=interview')">면접&nbsp;</button>|
        		<button id="studyCate" onclick="redirectTo('studyList.do?cate=work')">취준&nbsp;</button>|
        		<button id="studyCate" onclick="redirectTo('studyList.do?cate=else')">기타&nbsp;</button>
    		</div>
		</div><br>
		
		
		
		<div style='width:80%; margin-left:100px'>
			<div style='margin-left:660px'>
				<form action="searchStudy.do">
					<input type="search" placeholder="검색어를 입력하세요" id="search" name="search">
					<button type="submit" style= "width: 75px; padding: 5px; background-color: white;
						color: #26469B; border: 1px #26469B solid; border-radius: 4px; cursor: pointer;">search</button>
				</form>
			</div>
		<hr>
		<c:forEach items="${studyList}" var="slist">
			<c:choose>
            	<c:when test="${slist.cate eq 'coding'}"><p><b>[ 코테 ]</b></p></c:when>
                <c:when test="${slist.cate eq 'interview'}"><p><b>[ 면접 ]</b></p></c:when>
                <c:when test="${slist.cate eq 'work'}"><p><b>[ 취준 ]</b></p></c:when>
                <c:when test="${slist.cate eq 'else'}"><p><b>[ 기타 ]</b></p></c:when>
            </c:choose>
            <h4>📢 ${slist.title}</h4>
			<p style="margin-left:25px">➤<b>&nbsp;목&nbsp;표&nbsp;</b><br>${slist.goal}</p>
            <p style="margin-left:25px">➤<b>&nbsp;내&nbsp;용&nbsp;</b><br>${slist.content}</p>
            <button onclick="redirectTo('toChat.do?seq='+${slist.seq})" style="	width: 100px; height:30px;
				color: #26469B; border: 1px solid #26469B; background-color : white; border-radius: 4px;
				fontSize: 10px; cursor: pointer; margin-left: 850px;">참여하기</button>
            
            <c:if test="${slist.writerid eq sessionScope.id}">
        		<form action="deleteStudyPost.do?seq=${slist.seq}" method="post" >
        			<input type="submit" value="삭제하기" id="formBtn" style="border:none; width: 70px; height: 25px;
        			background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:885px"/>
        		</form>
        	</c:if>
            <hr>
    	</c:forEach>
		</div><br>
		
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
        
    </script>
</body>
</html>
