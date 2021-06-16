<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="board_view">
			<div class="board_content">
				<h3>${dto.no }번 게시글</h3>
				<p>작성자</p>
				${dto.author}<br><br>
				<p>작성일</p>
				${dto.postdate}<br><br>
				<p>작성자</p>
				${dto.ip}<br><br>
				<p>조회수</p>
				${dto.hit}<br><br>
				<p>제목</p>
				${dto.title }<br><br>
				<p>내용</p>
				<pre>${dto.content}</pre><br><br>	
				
			</div>
		</div>
		<div>
			<form action="/ServerProgram3/deleteBoard.do" method="post">
			<input type="hidden" name="no" value="${dto.no}">
			<button>삭제하기</button>
			
		
	</form>
			<input type="button" value="목록보기" id="btn" name="btn" onclick="location.href='/ServerProgram3/board.do'">
		</div>
		
		<%-- 댓글 입력창 --%>
		<div class="reply_form">
			<form action="/ServerProgram3/insertReply.do" method="post">
				<input type="hidden" name="boardIdx" value="${dto.no}"> 
				<input type="text" name="author" placeholder="작성자"> 
				<textarea name="content" placeholder="댓글"></textarea>
				
					<button>작성하기</button>
				
			</form>
		</div>
		
		<%-- 댓글 목록창 --%>
		<div class="reply_list">

			<table border="1">
				<tbody>
				
					<c:forEach var="replyDTO" items="${replyList}" varStatus="i">
			
						<tr>
							<td>${replyDTO.content}</td>
							<td>${replyDTO.author}</td>
							<td>${replyDTO.postdate}</td>	
						</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>

</body>
</html>