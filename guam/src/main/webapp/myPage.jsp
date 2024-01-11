<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="banner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/template.css">
<style>
        .MyPageContent {
            margin: 25px auto;
            width: 80%;
        }

        .Info {
            height: 250px;
            width: 30%;
            border: 2px solid #8B8DB9;
            float: left;
            margin-top: 50px;
            border-radius: 12px;
        }

        .Info p {
            text-align: left;
            font-weight: bold;
            font-size: 1.1em;
            margin-left: 20px;
        }

        .Info p span {
            margin-left: 20px;
        }
        .Info a {
            text-decoration: none;
        }

        .Track {
            width: 66%;
            margin-left: 38%;
            margin-top: 50px;
            min-height: 650px;
        }

        .Track p {
            display: flex;
            align-items: center;
            margin-left: -30px;
            font-size: 1.2em;
        }

        .Track p span {
            white-space: normal;
            word-wrap: break-word;
            margin-left: 10px;
        }
        #dialog{
        	display:none;
        }
    </style>
</head>
<body>
	<div class='mrgnlft'>	
	<div class='MyPageContent'>
        <div class='Info'>
            <p style='text-align: center'>INFO</p>
            <p>이름<span>${user.name}</span>
            <p>소속<span>${user.company}</span></p>
            <p>깃헙<span style="cursor:pointer;" onclick="toGit('github.com/hansojin')">${user.github}</span></p>
            <a href="updateInfo.do?id=${sessionScope.id}" style="text-decoration:none;">
                <p style="margin-right:20px; margin-top:30px; font-size:0.9em; color:gray; text-align:right;">수정하기</p>
            </a>
            <p onclick="handleClickOpen()" style="margin-right:20px; font-size:0.9em; cursor:pointer; color:gray; text-align:right;">탈퇴하기</p>
            <div id="dialog" title="회원 탈퇴">
                <p style='text-align: center; color:red'>정말 탈퇴 하시겠습니까?</p>
                <button onclick="handleClose()" style='margin-left: 70px'>취소</button>
                <button onclick="window.location.href='resign.do?id=${user.id}'">탈퇴하기</button>
                
            </div>
        </div>
        <div class='Track'>
            <p>
                <span style="margin-right:10px; color:gray;">🔍</span>작성한 글
            </p>
            <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Minima eaque atque tenetur error nostrum ipsum, vel harum blanditiis expedita optio nemo exercitationem distinctio beatae ullam omnis est libero natus illum. Lorem ipsum, dolor sit amet consectetur adipisicing elit. Amet possimus cupiditate, provident veritatis eius iusto hic, vitae error asperiores quidem accusamus, voluptate inventore porro. Laudantium cumque nesciunt atque perspiciatis quae?
            </p>
            <br />
            <p>
                <span style="margin-right:10px; color:gray;">📚</span>참여한 스터디
            </p>
            <p>
                <!-- 스터디 참여하기 목록 가져오기 -->
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Minima eaque atque tenetur error nostrum ipsum, vel harum blanditiis expedita optio nemo exercitationem distinctio beatae ullam omnis est libero natus illum. Lorem ipsum, dolor sit amet consectetur adipisicing elit. Amet possimus cupiditate, provident veritatis eius iusto hic, vitae error asperiores quidem accusamus, voluptate inventore porro. Laudantium cumque nesciunt atque perspiciatis quae?
            </p>
        </div>
    </div>
	</div>
</body>
</html>
<script>
    function toGit(gitLink) {
        window.open('https://' + gitLink, '_blank');
    }

    function handleClickOpen() {
        document.getElementById('dialog').style.display = 'block';
    }

    function handleClose() {
        document.getElementById('dialog').style.display = 'none';
    }
</script>