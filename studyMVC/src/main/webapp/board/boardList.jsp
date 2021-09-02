<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<div id='wrap' align='center'>
<h1>리스트</h1>
<table class='list'>
<tr>
<td colspan='5'>
<a href='../BoardServlet?command=board_write_form'>게시글 등록</a>
</td>
</tr>
<tr><th>번호</th></tr><tr><th>제목</th></tr><tr><th>작성자</th></tr><tr><th>작성일</th></tr><tr><th>조회</th></tr>
<c:forEach var='bo' items='${boardList }'>
<tr class='record'>
<td>${bo.num }</td>
<td><a href='BoardServlet?command=board_view&num=${bo.num }'>${bo.title }</a></td>
<td>${bo.name }</td>
<td><fmt:formatDate value='${board.writedate }'/></td>
<td>${bo.readcount }</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>