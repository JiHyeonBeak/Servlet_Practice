<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정을 찾을 수 없습니다</title>
<script type="text/javascript" src="js/loginScript.js"></script>
<style>
@font-face {
		font-family: 'timon';
		src : url('font/TMONBlack.ttf');
	}
	* {
		font-family: 'timon';
		text-align: center;
	}
	#main {
		position:absolute;
		left:550px;
		top:180px;
		width: 500px;
   		height: 400px;
   		border: 15px solid #5356a3;
    	border-radius: 20px;
    	margin: 10px;
	}
	h2{
		background-color: #ffffff;
		font-size:35px;
	}
	 #al{
		font-size: 25px;
	}
	#home{
		font-size: 20px;
	}
	#home:hover{
		font-size: 25px;
		color:red;
	}
	
</style>
</head>
<body>
	<div id="main">
	<form action="loginServ" name="frm" method="post">
	<br>
	<h2>경고창</h2><br>
	<p id="al">아이디를 찾을 수 없습니다!<br><br>
	다시한번 확인해주세요.</p><br>
	<p onclick="location.href='Login.jsp'" id="home">홈으로</p>
	</form></div>
	
</body>
</html>