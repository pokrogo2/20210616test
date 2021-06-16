<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		const f = $('#f');
		const title = $('#title');
		const author = $('#author');
		const content = $('#content');
		const insert_btn = $('#insert_btn');
		insert_btn.click(function(){
			if (title.val() == '' || content.val()=='' || author.val()=='' ) {
				alert('게시글 등록이 실패하였습니다.');
				
				return;
			}
			alert('게시글이 등록되었습니다.');
			f.attr('action', '/ServerProgram3/insertBoard.do');
			f.submit();
		})
		
		const list_btn = $('#list_btn');
		list_btn.click(function(){
			location.href = '/ServerProgram3/selectListBoardCommand.do';
		})
		
	})
</script>
</head>

<body>
<div class="insert_form">
	<h2>게시글 작성하기</h2>
	<form id="f" method="post" >
		<p>작성자</p>
		<input type="text" id="author" name="author" ><br><br>
		<p>제목</p>
		<input type="text" id="title" name="title"><br><br>
		
		<p>내용</p>
		<textarea id="content" id="content" name="content" ></textarea><br><br>
	
		<div>
			
			<input type="button" value="저장하기" class="btn" id="insert_btn">
			<input type="reset" value="작성초기화" class="btn" id="reset_btn">
			<input type="button" value="목록보기" class="btn" id="list_btn">
		</div>
	</form>
	
</div>
</body>
</html>