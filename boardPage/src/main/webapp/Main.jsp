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
</head>
<body>
	<form action="addServ" method="post">
	제목 : <textarea rows="3" cols="3" name="title"></textarea>
	내용 : <textarea rows="3" cols="3" name="content"></textarea>
	<input type="submit" value="확인">
	</form>
	<form action="boardServ" method="post">
	<table>
	<c:forEach var="board" items="${boardlist }">
	<tr>
	<td>${board.no }</td>
	<td>${board.title }</td>
	<td>${board.content }</td>
	<td>${board.wdate }</td>
	</tr>
	</c:forEach>
	</table>
	</form>
</body>
</html>