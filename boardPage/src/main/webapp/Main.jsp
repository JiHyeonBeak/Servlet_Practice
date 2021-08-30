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
	var dt = new Date();
	var day = dt.toDateString();
	document.getElementById('day').innerText = day;

</script>
<link rel="stylesheet" type="text/css" href="css/css_main.css">
</head>
<body>
	<center>
	<h1>익명의 메아리 창고</h1>
	<div id='back'>
	<form action="addServ" method="post" id="txt">
	<table>
	<tr><td><p id='day'></p></td></tr>
	<tr><td>제목 : </td><td><textarea rows="3" cols="100" name="title"></textarea></td>
	<td rowspan="4"><input id="add" type="submit" value="확인"></td></tr>
	<tr><td>내용 : </td><td><textarea rows="15" cols="100" name="content"></textarea></td></tr>
	</table>
	</form>
	<form action="boardServ" method="post" id="posts">
	<table id='res'>
	<c:forEach var="board" items="${boardlist }">
	<tr>
	<td  colspan='1'>${board.no }</td>
	<td colspan='4'>${board.title }</td></tr>
	<tr>
	<td colspan='4'>${board.content }</td></tr>
	<tr>
	<td>${board.wdate }</td></tr>
	</c:forEach>
	</table>
	</form>
	</div>
	</center>
</body>
</html>