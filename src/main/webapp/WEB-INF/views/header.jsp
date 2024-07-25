<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.header {
	background-color: #ffffff;
	width: 100%;
	padding: 10px 20px;
	box-sizing: border-box;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-bottom: 1px solid #e5e5e5;
}

.logo a {
	text-decoration: none;
	font-size: 24px;
	font-weight: bold;
	color: #333333;
}

.link {
	margin-left: 20px;
	text-decoration: none;
	color: #007bff;
	font-weight: bold;
}

.search-form {
	display: flex;
	align-items: center;
}

.search-input {
	width: auto !important;
	padding: 8px !important;
	border: 1px solid #ddd;
	border-radius: 5px 0 0 5px !important;
	outline: none;
}

.search-button {
	width: 80px !important;
	padding: 8px 16px;
	border: none;
	border-radius: 0 5px 5px 0 !important;
	background-color: #007bff;
	color: white;
	cursor: pointer;
	font-size: 14px;
	transition: background-color 0.3s;
}

.search-button:hover {
	background-color: #0056b3;
}

.right-menu {
 	display:flex;
 	align-items:center;
 }
</style>
<div class="header">
	<div class="logo">
		<a href="/tech_blog/main">velog</a>
	</div>
	<div class="right-menu">
		<form action="${pageContext.request.contextPath}/main" method="POST" class="search-form">
			<input type="text" name="keyword" id="keyword" class="search-input" />
			<button type="submit" class="search-button">검색</button>
		</form>
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<a href="${pageContext.request.contextPath}/logout" class="link">로그아웃</a>
				<a href="${pageContext.request.contextPath}/create_board"
					class="link">글 작성</a>
				<a href="${pageContext.request.contextPath}/info" class="link">유저
					정보</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/login" class="link">로그인</a>
				<a href="${pageContext.request.contextPath}/register" class="link">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>