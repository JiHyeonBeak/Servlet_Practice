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
	table {
	border: 1px solid black;
	}
	td {
	border: 1px solid black;
	}
	tr {
	border: 1px solid black;
	}

</style>
<script type="text/javascript">
function open_win(url,name) {
	window.open(url,name,"width=500,height=230");
}

</script>
</head>
<body>
	<div id='wrap' align='center'>
	<h1>게시글 상세보기</h1>
	<table>
	<tr><th>작성자</th><td>${board.name }</td>
	<th>이메일</th><td>${board.email }</td></tr>
	
	<tr><th>작성일</th><td>${board.writedate}</td>
	<th>조회수</th><td>${board.readcount }</td></tr>
	
	<tr><th>제목</th><td colspan='3'>${board.title }</td></tr>
	
	<tr><th>내용</th><td colspan='3'><pre>${board.content }</pre></td></tr>
	</table>
	
	<input type='button' value='수정' onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}','update')">
	<input type='button' value='삭제' onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}','delete')">
	<input type='button' value='게시글리스트' onclick="location.href='BoardServlet?command=board_list'">
	
	</div>
</body>
</html>