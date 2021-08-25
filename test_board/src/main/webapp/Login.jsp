<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<script type="text/javascript" src="js/loginScript.js"></script>
<style>
@font-face {
		font-family: 'timon';
		src : url('font/TMONBlack.ttf');
	}
	* {
		font-family: 'timon';
	}
	#main {
		position:absolute;
		left:550px;
		top:180px;
		text-align:center;
		width: 500px;
   		height: 400px;
   		border: 15px solid #5356a3;
    	border-radius: 20px;
    	margin: 10px;
	}
	h2{
		background-color: #ffffff;
		font-size:30px;
	}
	table {
		position: relative;
		left:120px;
		top:20px;
	}
	#lg, #join {
		width:100px;
		height:40px;
		margin-top: 10px;
		margin-right: 10px;
	}
</style>
</head>
<body>
	<div id="main">
	<form action="loginServ" name="frm" method="post">
	<br>
	<h2>로그인</h2><br>
	<table>
		<tr><td>아이디 :</td><td><input type="text" name="user_id"></td></tr>
		<tr rowspan=2><td></td></tr>
		<tr><td>암 호 :</td><td><input type="password" name="user_pwd"></td></tr>
	</table><br><br>
		<input onclick="fnlogin()" type="button" value="로그인" id="lg">&nbsp;
		<input type="button" value="회원가입" id="join" onclick="location.href='joinServ'">
	</form></div>
	
</body>
</html>