<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Velog Clone</title>
<link rel="stylesheet" href="styles.css">
</head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #ffffff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo {
	font-size: 24px;
	font-weight: bold;
}

.nav ul {
	list-style: none;
	display: flex;
	margin: 0;
	padding: 0;
}

.nav ul li {
	margin-right: 20px;
	cursor: pointer;
}

.login {
	cursor: pointer;
}

.content {
	max-width: 1200px;
	margin: 20px auto;
	padding: 20px;
	background-color: #ffffff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.trending {
	margin-bottom: 20px;
}

.trending h2 {
	font-size: 24px;
	margin-bottom: 10px;
}

.posts {
	display: flex;
	justify-content: space-between;
}

.post-card {
	width: 30%;
	background-color: #ffffff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
	overflow: hidden;
}

.post-card img {
	width: 100%;
	height: auto;
}

.post-content {
	padding: 15px;
}

.post-content h3 {
	font-size: 18px;
	margin-bottom: 10px;
}

.post-content p {
	font-size: 14px;
	margin-bottom: 10px;
}

.post-content .date, .post-content .comments {
	font-size: 12px;
	color: #888;
}
</style>
<body>
	<div class="header">
		<div class="logo">velog</div>
		<a href="/tech_blog/login" class="login">로그인</a>
	</div>
	<div class="content">
		<div class="trending">
			<h2>기술-프로그래밍</h2>
			<div class="posts">
				<c:forEach var="board" items="${boards}">
					<div class="post-card">
						<a href="/board/1" style="text-decoration: none;">
							<div class="post-content">
								<h3>${board.title }</h3>
								<p>${board.content }</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>