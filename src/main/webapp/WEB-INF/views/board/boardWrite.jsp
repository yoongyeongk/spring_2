<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
	text-align: center;
}
table {
	margin: 0 auto;
	width: 500px;
	border: 1px solid #ddd;
	border-collapse: collapse;
}
td{
	height: 25px;
	text-align: center;
	padding: 10px;
}
input{
	padding: 3px;
	width: 200px;
	border-radius: 4px;
	border: 1px solid #ddd;
}
.content textarea{
	height: 100px;
	width: 95%;
	border: 1px solid #ddd;
	border-radius: 4px;
	color: gray;
}
.btn{
	padding: 5px 7px;
	border-radius: 4px;
	font-size: 17px;
}
</style>
</head>
<body>
	<h1>${board} Write Form</h1>
	
	<form action="${board}Write" method="post">
		<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목을 입력해주세요."></td>
			<td><input type="text" name="writer" placeholder="글쓴이를 입력해주세요."></td>
		</tr>
		<tr>
			<td class="content" colspan="2"><textarea name="contents" draggable="false">내용을 입력해주세요.</textarea></td>
		</tr>
	</table>
	<button class="btn">write</button>
	</form>
</body>
</html>