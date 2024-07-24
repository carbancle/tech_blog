<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성/수정</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.form-container {
	background-color: #ffffff;
	padding: 20px 40px;
	border-radius: 10px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 500px;
	margin-top: 50px;
}

h2 {
	text-align: center;
	color: #333333;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	color: #666666;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-sizing: border-box;
}

textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="form-container">
		<h2>게시글 작성/수정</h2>
		<c:set var="isUpdate" value="${not empty board.id}" />
		<form
			action="${pageContext.request.contextPath}/${isUpdate ? 'update_board' : 'create_board'}"
			method="post">
			<c:if test="${isUpdate}">
				<input type="hidden" name="id" value="${board.id}" />
			</c:if>
			<div class="form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="title" value="${board.title}" required />
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea id="content" name="content" rows="5" required><c:out value="${board.content}"/></textarea>
			</div>
			<button type="submit">${isUpdate ? '수정' : '제출'}</button>
		</form>
	</div>
</body>
</html>
