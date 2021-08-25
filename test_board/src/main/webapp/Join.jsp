<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
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
		margin-top:40px;
		background-color: #ffffff;
		font-size:30px;
	}
	table {
		position: relative;
		left:120px;
		top:10px;
	}
	#can, #join {
		width:100px;
		height:40px;
		margin-top: 10px;
		margin-right: 10px;
	}

</style>
</head>
<body>
	<center><form action="joinServ" name='frm' method="post">
	<div id="main">
	<h2>회 원 가 입</h2>
	<table>
		<tr><td>아이디 :</td><td><input type="text" name="join_id"></td></tr>
		<tr rowspan=2><td></td></tr><tr rowspan=2><td></td></tr>
		<tr><td>암 호 :</td><td><input type="password" name="join_pwd"></td></tr>
		<tr rowspan=2><td></td></tr><tr rowspan=2><td></td></tr>
		<tr><td>이 름 :</td><td><input type="text" name="join_name"></td></tr>
		<tr rowspan=2><td></td></tr><tr rowspan=2><td></td></tr>
		<tr><td>이메일 :</td><td><input type="text" name="join_email"></td></tr>
	</table>
	<br><br>
	<input type="button" value="회원가입" id="join" onclick="fnmember()">&nbsp;
	<input type="button" value="취소" id="can" onclick="location.href='loginServ'">
	</div>
	</form></center>
</body>
</html>