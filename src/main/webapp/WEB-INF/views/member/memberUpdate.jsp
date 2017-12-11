<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member Update</h1>
	
	<form action="./memberUpdate" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="2"><input type="file" name="f1"></td>
		</tr>
		<tr>
			<td>Id</td>
			<td><input type="text" name="id" value="${member.id}"></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name" value="${member.name}"></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><input type="tel" name="phone" value="${member.phone}"></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="email" name="email" value="${member.email}"></td>
		</tr>
	</table>
	
	<button>update</button>
	</form>
	
</body>
</html>