<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<div id='wrap' align='center'>
	<h1>게시글 수정</h1>
	<form name='frm' method='post' action='BoardServlet'>
	<input type='hidden' name='command' value='board_update'>
	<input type='hidden' name='num' value='${board.num }'>
	<table>
	<tr><th>작성자</th><td><input type='text' size='12' name='name' value='${board.name }'> *필수 </td></tr>
	<tr><th>비밀번호</th><td><input type='password' size='12' name='pass' value='${board.pass }'> *필수 </td></tr>
	<tr><th>이메일</th><td><input type='text' size='40' maxlength='50' name='email' value='${board.email }'></td></tr>
	<tr><th>제목</th><td><input type='text' size='70' name='title' value='${board.title }'></td></tr>
	<tr><th>내용</th><td><textarea cols='70' row='15' name='content'>${board.content }</textarea></td></tr>
	</table>
	<br><br>
	<input type='submit' value='등록' onclick='return boardCherck()'>
	<input type='button' value='목록' onclick="location.href='studyMVC/BoardServlet?command=board_list'">
	</form>
</div>
</body>
</html>