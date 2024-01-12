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
        <hr style="margin-bottom: 25px; margin-top: 25px;" />
        <p>Comments</p>
        <textarea name="comment" id="comment" placeholder="댓글을 입력하세요" rows="4" cols="93" style="vertical-align: top; padding:5px"></textarea>
		<button onclick="addComment(${commList.seq},'${sessionScope.id}')" style="width: 60px; padding: 5px; color: #26469B; height: 100px; 
    		border: 1px solid #26469B; background-color: white; border-radius: 4px; font-size: 16px; cursor: pointer; vertical-align: top;">등록</button>
    </div><br><br>
    
    <div style="width:78%; margin: 0px 110px" id="commentDiv">
    	👤 
    </div>
    
	<script>
	function addComment(commseq,id) {
		var content = document.getElementById('comment').value;
		content = encodeURIComponent(content);
		console.log(content)
		window.location.href = 'addComment.do?commseq=' + commseq + '&writerid=' + id + '&content=' + content;
    }
	
	
	</script>
	
</body>
</html>