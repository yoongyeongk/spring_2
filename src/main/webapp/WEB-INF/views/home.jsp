<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	var message = '${message}';	
	if(message != ""){
		alert(message);	
	}
	</script>
</head>
<body>
<c:if test="${empty member}">
<a href="./member/memberLogin">Login</a>
<a href="./member/memberJoin">Join</a>
</c:if>
<c:if test="${not empty member}">
<a href="./member/memberLogout">Logout</a>
<a href="./member/memberMypage">MyPage</a>
</c:if>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./notice/noticeList">notice</a>
<a href="./qna/qnaList">qna</a>
</body>
</html>
