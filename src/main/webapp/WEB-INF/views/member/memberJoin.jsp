<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	
	<form name="frm" action="./memberJoin" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"><span id="idCheck"></span></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pw"><span id="pwcheck"></span></td>
			</tr>
			<tr>
				<td>password check</td>
				<td><input type="password"><span id="pwCheck2"></span></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="tel" name="phone"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
		</table>
		<input type="file" name="f1">
		
		<input type="submit" id="submitBtn" value="join">
		<input type="reset" value="reset">
 	</form>

</body>
</html>