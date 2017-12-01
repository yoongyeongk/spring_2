<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
.fileSec{
	margin: 0 15%;
}
</style>
<script type="text/javascript">
	$(function(){
	var a = $("#fileSec").html();
		$(".fileSec").on("click","#add",function(){
			if($(".fileDiv").length < 5){
				$("#fileAdd").append(a);				
			}else{
				alert("5개 까지 추가가 가능합니다.");
			}
		});
		
		$(".fileSec").on("click","#delete", function(){
			$(this).parent().remove();
		})
		
		 
		 //쌤 방식
	/* 	var index = 0;
		var count = 0;
		$("#add").click(function(){
			if(count < 5){
				var s = '<div id="d'+index+'">';
				s = s+'<input type="file" name="f1"><span class="del" title="d'+index+'">X</span></div>';
				$("#files").append(s);
				count++;
				index++;
			}else{
				alert("fail");
			}
		})
		
		$("#files").on("click",".del",function(){
			var id = $(this).attr("title");
			$("#"+id).remove();
			index--;
		}); */
		
	});
</script>
</head>
<body>
	<h1>${board} Write Form</h1>
	
	<form action="${board}Write" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목을 입력해주세요."></td>
			<td><input type="text" name="writer" placeholder="글쓴이를 입력해주세요."></td>
		</tr>
		<tr>
			<td class="content" colspan="2"><textarea name="contents" draggable="false">내용을 입력해주세요.</textarea></td>
		</tr>
	</table>
	
	<div class="fileSec" id="fileSec">
	<div class="fileDiv">
	<input type="file" name="f1">
	<input type="button" value="File Add" id="add">
	<input type="button" value="delete" id="delete">
	</div>
	</div>
	<div class="fileSec" id="fileAdd"></div>
	<!-- <div id="files"></div> -->
	
	<button class="btn">write</button>
	</form>
</body>
</html>