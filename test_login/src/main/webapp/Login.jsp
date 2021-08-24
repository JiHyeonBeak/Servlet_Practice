<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 창</title>
</head>
<body>
	<form action="loginServ" method="post">
	아이디 : <input type="text" name="user_id">
	비밀번호 : <input type="password" name="user_pwd">
	<input type="submit" value="로그인">
	</form>
</body>
</html>