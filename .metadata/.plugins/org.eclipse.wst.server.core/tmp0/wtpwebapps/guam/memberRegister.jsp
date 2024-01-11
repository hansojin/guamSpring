<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
</head>
<body>
	<div class='formCss'>
	<h3>회원가입</h3>
	<form action="memberRegister.do">
		<table>
			<tr>
				<td><label for="id">아이디</label></td><td><input type="text" name="id" id="id"/><div id="idCheckMsg"></div>
			</tr>
			<tr>
				<td><label for="password">비밀번호</label></td><td><input type="password" name="password" id="password"/>
			</tr>
			<tr>
				<td><label for="name">이름</label></td><td><input type="text" name="name" id="name"/>
			</tr>
			<tr>
				<td><label for="company">소속</label></td><td><input type="text" name="company" id="company"/>
			</tr>
			<tr>
				<td><label for="github">깃헙</label></td><td><input type="text" name="github" id="github"/>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입" id="formBtn"/></td>
			</tr>
		</table>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script>
		$('#id').on('focusout', function(){
			let id = $('#id').val();

			$.ajax({
				url : "idCheck.do",		// 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				type:  "post",			// HTTP 요청방식 (get/post)
				data: {"id": id},		// HTTP 요청과 함께 서버로 보낼 데이터
				dataType: 'text',		// 서버에서 보내줄 데이터의 타입
				// 성공적으로 값을 서버로 보냈을 경우 처리하는 코드
				success: function(result){
					if(result == 0){
						$("#idCheckMsg").html('사용할 수 없는 아이디 입니다.');
					} else{
						$("#idCheckMsg").html('사용할 수 있는 아이디 입니다.');
					}
				},
				error:function(){
					alert("서버요청실패");
				}
			})
		})
	</script>
	</div>	
</body>
</html>