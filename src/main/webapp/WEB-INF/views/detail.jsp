<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 20px;
	/* justify-content: center; */
	height: 100vh;
}

.post-container {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	max-width: 800px;
	box-sizing: border-box;
	margin: 0 auto;
	margin-top: 50px;
}

.post-container h2 {
	margin-top: 0;
	color: #333333;
}

.post-container p {
	color: #666666;
}

.post-actions {
	max-width: 800px;
	margin: 0 auto;
	margin-top: 20px;
	text-align: right;
}

.post-actions form {
	display: inline;
}

.post-actions button {
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-right: 10px;
}

.post-actions .update-button {
	background-color: #007bff;
}

.post-actions .update-button:hover {
	background-color: #0056b3;
	transition: .6s;
}

.post-actions .delete-button {
	background-color: #dc3545;
}

.post-actions .delete-button:hover {
	background-color: #c82333;
	transition: .6s;
}

.back-button {
	background-color: #6c757d;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
}

.back-button:hover {
	background-color: #5a6268;
	transition: .6s;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="post-container">
		<h2>${board.title }</h2>
		<p>${board.content }</p>
		<p>작성자: ${board.userId }</p>

		<c:if test="${board.userId == sessionScope.user.userId}">
			<div class="post-actions">
				<form
					action="${pageContext.request.contextPath}/update_board/${board.id }"
					method="get">
					<input type="hidden" name="id" value="${board.id}" />
					<button type="submit" class="update-button">수정</button>
				</form>
				<form action="${pageContext.request.contextPath}/delete_board"
					method="post">
					<input type="hidden" name="id" value="${board.id}" />
					<button type="submit" class="delete-button">삭제</button>
				</form>
			</div>
		</c:if>
	</div>
	<div class="post-actions">
		<a href="${pageContext.request.contextPath}/main" class="back-button">뒤로가기</a>
	</div>
</body>
</html>
