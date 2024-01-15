<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
</head>
<body>
	
    <div style="width:78%; margin : 30px 110px">
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
        <h2>${commList.title}</h2>
        <hr style="margin-bottom: 25px; margin-top: 25px;" />
        <p>${commList.content}</p><br />
        <p>✒️ ${commList.writerid}</p>
        <p>👁️ ${commList.view}&nbsp;&nbsp;💬 ${commList.reply}</p>
        <c:if test="${commList.writerid eq sessionScope.id}">
			<form action="toEdit.do?seq=${commList.seq}" method="post" >
        		<input type="submit" value="수정하기" id="formBtn" style="border:none; width: 70px; height: 25px;
        			background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:870px"/>
        	</form> 
        	<form action="deletePost.do?seq=${commList.seq}" method="post" >
        		<input type="submit" value="삭제하기" id="formBtn" style="border:none; width: 70px; height: 25px;
        			background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:870px"/>
        	</form>
        </c:if>
        
        <hr style="margin-bottom: 25px; margin-top: 25px;" />
        
        <p>Comments</p>
        <textarea name="comment" id="comment" placeholder="댓글을 입력하세요" rows="4" cols="93" style="vertical-align: top; padding:5px"></textarea>
		<button onclick="addComment(${commList.seq},'${sessionScope.id}')" style="width: 60px; padding: 5px; color: #26469B; height: 100px; 
    		border: 1px solid #26469B; background-color: white; border-radius: 4px; font-size: 16px; cursor: pointer; vertical-align: top;">등록</button>
    </div><br><br>
    
    <div style="width:78%; margin: 0px 110px" id="commentDiv">
    	<c:forEach items="${commentList}" var="comment">
			<p>👤 <b>${comment.writerid}</b></p>
			<p style='margin-left:30px'>${comment.content}</p>
			<c:if test="${comment.writerid eq sessionScope.id}">
				<form action="deleteComment.do" method="post">
					<input type="hidden" name="idx" value="${comment.idx}">
    				<input type="hidden" name="seq" value="${comment.seq}">
        			<input type="submit" value="삭제하기" id="formBtn" style="border:none; width: 70px; height: 25px;
        				background-color: white; color:gray; font-style: italic;font-size: 0.7em;margin-left:870px"/>
        		</form> 
        	</c:if>
			<hr>
		</c:forEach>
    	 
    </div>
    
    <div >
			
		</div>
    
	<script>
	function addComment(seq,id) {
		var content = document.getElementById('comment').value;
		content = encodeURIComponent(content);
		console.log(content)
		window.location.href = 'addComment.do?seq=' + seq + '&writerid=' + id + '&content=' + content;
    }
	
	
	</script>
	
</body>
</html>