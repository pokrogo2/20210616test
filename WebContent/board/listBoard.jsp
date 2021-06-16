<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="board_list">
		
		<input type="button" value="새글작성" onclick="location.href='/ServerProgram3/insertBoardPage.do'">
	
		
		
		<table>
			<thead>
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" varStatus="i">
				
					<c:if test="${i.last }">전체 게시글 : ${dto.no } 개</c:if>
						<tr>
							<td>${dto.no}</td>
							<td><a href="/ServerProgram3/selectOneBoard.do?no=${dto.no}">${dto.title}</a></td>
							<td>${dto.author}</td>			
							<td>${dto.postdate}</td>
							<td>${dto.hit}</td>
						</tr>
					
				</c:forEach>
			</tbody>
		</table>
		
	</div>

</body>
</html>