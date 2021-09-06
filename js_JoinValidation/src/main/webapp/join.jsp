<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function fn_ok() {
	var name = frm.name.value;
	var id = frm.id.value;
	var pwd = document.getElementsByName('pwd')[0].value;
	var email = frm.email.value;
	var birth = Date.parse(frm.birth.value);
	
	if(name == null || name ==''){
		alert('이름을 입력해주세요.');
		frm.name.focus();
	}else if(id == null || id ==''){
		alert('아이디를 입력해주세요,');
		frm.id.focus();
	}else if(pwd == null || pwd ==''){
		alert('암호를 입력해주세요,');
		frm.pwd.focus();
	}else if(email == null || email ==''){
		alert('이메일을 입력해주세요,');
		frm.email.focus();
	}else if($(':radio[name=gender]:checked').length < 1){
		alert('성별을 입력해주세요.');
	}else if(isNaN(birth)){
		alert('생일을 입력해주세요.');
	}
	else{
		frm.action = 'joinServ';
		frm.method = 'post';
		frm.submit();
	}
}

</script>
</head>
<body>
	<form action="joinServ" method="post" name='frm'>
	<table border="1">
	<tr><td>이름</td><td><input type="text" size="20" name="name"></td></tr>
	<tr><td>아이디</td><td><input type="text" size="20" name="id"></td></tr>
	<tr><td>비밀번호</td><td><input type="password" size="20" name="pwd"></td></tr>
	<tr><td>이메일</td><td><input type="text" size="20" name="email"></td></tr>
	<tr><td>성별</td><td>여성<input type="radio" name="gender" id='female' value='여성'>남성<input type="radio" id='male' name="gender" value='남성'></td></tr>
	<tr><td>생년월일</td><td><input type="date" name="birth"></td></tr>
	<tr><td><input type="button" value="가입" onclick="fn_ok()"></td><td><input type="reset" value="다시쓰기"></td></tr>
	</table>
	</form>
</body>
</html>