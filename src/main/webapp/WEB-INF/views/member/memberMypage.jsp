<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mypage</h1>
	
	<table>
		<tr>
			<td colspan="2"><img src="../resources/upload/${member.fname}"></td>
		</tr>
		<tr>
			<td>Id</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>phone</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${member.email}</td>
		</tr>
	</table>
	
	<a href="./memberUpdate?id=${member.id}">update</a>
	<a href="./memberDelete?id=${member.id}">delete</a>
</body>
</html>