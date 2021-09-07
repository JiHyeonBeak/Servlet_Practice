<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script type="text/javascript">
function time(){
	var dt = new Date();
	var day = dt.getFullYear()+"."+(dt.getMonth()+1)+"."+dt.getDate();
	document.getElementById('day').innerHTML = "오늘은... "+day+"&nbsp;";
};
	window.onload = function() {
		time();
	};

</script>
<link rel="stylesheet" type="text/css" href="css/css_main.css">
</head>
<body>
	<center>
	<div id='all'>
	<h1>익명의 메아리 창고</h1>
	<div id='back'>
	
	<form action="addServ" method="post" id="txt">
	<table id="inp">
	<tr><td id='dy'colspan="100"><p id='day'></p></td></tr>
	<tr><td>제목 : </td><td><textarea rows="3" cols="100" name="title"></textarea></td>
	<td rowspan="4"><input id="add" type="submit" value="확인"></td></tr>
	<tr><td>내용 : </td><td><textarea rows="15" cols="100" name="content"></textarea></td></tr>
	</table>
	</form>
	
	<form action="boardServ" method="post" id="posts">
	<table id='res'>
	<c:forEach var="board" items="${boardlist }">
	<tr>
	<td>${board.no }</td>
	<td colspan="2">${board.title }</td></tr>
	<tr>
	<td colspan="4">${board.content }</td></tr>
	<tr>
	<td colspan="4">${board.wdate }</td></tr>
	</c:forEach>
	</table>
	</form>
	</div>
	</div>
	</center>
</body>
</html>