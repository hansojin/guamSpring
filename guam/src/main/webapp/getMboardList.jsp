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
</head>
<body>
    <div>
    	<br><br><button id="toggleBtn">모집글 작성</button><br>
        <!-- 에디터를 적용할 요소 (컨테이너) -->
        <div id="toggleDiv" style="display: none">
        	<p style="font-size: 0.7em; margin-left: 170px; font-weight: bold; color:gray">MARKDOWN 지원</p>
        	<div id="content" style="width:60%; margin-left: 170px"></div>
        	<br><button id="cancelBtn" style="margin-left: 380px; ">취소하기</button><button id="submitButton" style="margin-left: 10px; ">모집하기</button>
		</div>
		
        <form id="myForm" action="insertMboard.do" method="post">
            <input name="cate" type="hidden" value="m" />
            <input name="writerid" type="hidden" value="${sessionScope.id}" />
            <input name="content" type="hidden" id="contentInput" />
        </form>
        
        
        <br><h2 style="margin-left: 80px; font-weight: bold">모집 글</h2>
        <hr style="margin-left: 80px;width:80%">
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
        

		
        <p style='text-align: center'>&copy; 2024 GUAM</p>
    </div>
    <!-- TUI 에디터 JS CDN -->
    <script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script> 
    <script>	
        const editor = new toastui.Editor({
            el: document.querySelector('#content'), 
            height: '300px',                        
            initialEditType: 'markdown',            
            previewStyle: 'vertical'                
        });
        
	
		// 글 등록 form 제출
        document.getElementById('submitButton').addEventListener('click', function() {
            const contentValue = editor.getMarkdown(); 
            const contentWithLineBreaksAndTabs = contentValue.replace(/[\n\t]/g, function(match) {
                return match === '\n' ? '<br>' : '&nbsp;&nbsp;&nbsp;&nbsp;'; 
            });
            console.log(contentValue);
            document.getElementById('contentInput').value = contentWithLineBreaksAndTabs;
            document.getElementById('myForm').submit();
        });
        
     	// 글 작성 toggle
        document.getElementById('toggleBtn').addEventListener('click', function() {
            var toggleDiv = document.getElementById('toggleDiv');
            if (toggleDiv.style.display === 'none' || toggleDiv.style.display === '') {
                toggleDiv.style.display = 'block';
            } else {
                toggleDiv.style.display = 'none';
            }
        });
     	
        document.getElementById('cancelBtn').addEventListener('click', function() {
        	var toggleDiv = document.getElementById('toggleDiv');
            toggleDiv.style.display = 'none';
        });
        
        

    </script>
</body>
</html>
