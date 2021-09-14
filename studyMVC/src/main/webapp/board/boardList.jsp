<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	th {
	border:1px solid black;
	}
	tr {
	border:1px solid black;
	}
	td {
	border:1px solid black;
	}
	.list{
	text-align: center;
	}
</style>
</head>
<body>
<div id='wrap' align='center'>
<h1>리스트</h1>
<table class='list'>
<tr>
<td colspan='5'>
<a href='./BoardServlet?command=board_write_form'>게시글 등록</a>
</td>
</tr>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th></tr>
<c:forEach var='bo' items='${boardList }'>
<tr class='record'>
<td>${bo.num }</td>
<td><a href='./BoardServlet?command=board_view&num=${bo.num }'>${bo.title }</a></td>
<td>${bo.name }</td>
<td>${bo.writedate }</td>
<td>${bo.readcount }</td>
</tr>
</c:forEach>
</table>

</div>
</body>
</html>