<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script type="text/javascript">
	function fn_submit(){
		frm.action = "writeServ";
		frm.method = "post";
		frm.submit();
	}
</script>
<style>
@font-face {
		font-family: 'timon';
		src : url('font/TMONBlack.ttf');
	}
	* {
		font-family: 'timon';
	}
	h1{	
		margin-top:40px;
		background-color: #ffffff;
		font-size:30px;
		text-align: center;
	}
	table {
		position: absolute;
		left:250px;
		top:115px;
		border:5px solid #5356a3;
		width:1100px;
		height:550px;
	}
	td ,th {
		border:3px solid #5356a3;
	}
	p:hover{
		color:gray;
	}
</style>
</head>
<body>
	<form action="writeServ" name="frm" method="post">
	<h1> 4조 게시판</h1>
	<table>
	<tr><td>제목</td><td><input type="text" name="title"></td></tr>
	<tr><td>내용</td><td><textarea cols="70" row="15" name="content"></textarea></td></tr>
	<tr><td><p onclick="fn_submit()">작성 완료</p></td></tr>
	</table>	
	</form>
</body>
</html>