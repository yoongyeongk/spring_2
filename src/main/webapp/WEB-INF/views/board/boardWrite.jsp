<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
	text-align: center;
}
table {
	margin: 0 auto;
	width: 1000px;
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
	margin: 1% 24%;
}
#add{
	width: 135px;
}
#delete{
	width: 135px;
}
</style>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	$(function(){
		//SmartEditor start
		//전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        //textarea ID
        elPlaceHolder: "contents",
        sSkinURI: "../resources/SE2/SmartEditor2Skin.html", 
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true, 
        }
    });
     
    //전송버튼 클릭이벤트
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
         
        // 이부분에 에디터 validation 검증
         
        //폼 submit
        $("#frm").submit();
    })
		
		//CKEDITOR.replace( 'contents' );
		
		var a = $("#fileSec").html();
			$(".fileSec").on("click","#add",function(){
				if($(".fileDiv").length < 5){
					$("#fileAdd").append(a);				
				}else{
					alert("5개까지 추가가 가능합니다.");
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
	
	<form action="${board}Write" method="post" enctype="multipart/form-data" id="frm">
		<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목을 입력해주세요."></td>
			<td><input type="text" name="writer" placeholder="글쓴이를 입력해주세요."></td>
		</tr>
		<tr>
			<td class="content" colspan="2"><textarea id="contents" name="contents" draggable="false">내용을 입력해주세요.</textarea></td>
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
	
	<input type="button" id="savebutton" value="write">
	</form>
</body>
</html>