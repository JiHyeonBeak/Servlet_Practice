<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function oncl() {
		pp.submit();
	}

</script>
</head>
<body>
	<form action="boardServ" method="post" name="pp">
	<p onclick="oncl()">게시판으로</p>
	</form>
</body>
</html>