<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script>
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
</style>
</head>
<body>
	<form action="boardServ" method="post" name="frm">
	<h1> 4조 게시판</h1>
	<table>
	<tr><th>번호</th> <th colspan=4>제목</th> <th>작성자</th> <th>작성일</th></tr>
	<c:forEach var="board" items="${boardlist }">
	<tr>
		<td>${board.no }</td>
		<td colspan="4">${board.title }</td>
		<td>${board.writer }</td>
		<td>${board.wdate }</td>
	</tr>
	</c:forEach>
	<tr><td><p onclick="location.href='Board_write.jsp'">글작성</p></td></tr>
	</table>
	
	
	
	</form>
</body>
</html>