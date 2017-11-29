<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} list Page</h1>
	<table>
		<tr>
			<th>no.</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.num}</td>
			<td>
			<c:catch>
			<c:forEach begin="1" end="${dto.depth}">
				ㄴ
			</c:forEach>
			</c:catch>
			<a href="#">${dto.title}</a>
			</td>
			<td>${dto.writer}</td>
			<td>${dto.reg_date}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>