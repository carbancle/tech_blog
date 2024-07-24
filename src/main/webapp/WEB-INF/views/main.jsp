<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 20px;
    }
    .content {
        padding: 20px;
    }
    .trending {
        max-width: 1200px;
        margin: 0 auto;
    }
    .posts {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }
    .post-card {
        flex: 1 1 calc(25% - 40px);
    }
    .post-card a {
    	display: block;
    	padding: 20px;
        box-sizing: border-box;
    	background-color: #ffffff;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    
    .post-card a:hover {
    	transition: .6s;
    	background: rgba(0, 0, 0, 0.3);
    }
    
    .post-content {
        color: #333333;
    }
    .post-content h3 {
        margin-top: 0;
        font-size: 18px;
    }
    .post-content p {
        font-size: 14px;
        color: #666666;
    }
    @media (max-width: 1200px) {
        .post-card {
            flex: 1 1 calc(33.333% - 40px);
        }
    }
    @media (max-width: 768px) {
        .post-card {
            flex: 1 1 calc(50% - 40px);
        }
    }
    @media (max-width: 480px) {
        .post-card {
            flex: 1 1 calc(100% - 40px);
        }
    }
</style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="content">
        <div class="trending">
            <h2>기술-프로그래밍</h2>
            <div class="posts">
                <c:forEach var="board" items="${boards}">
                    <div class="post-card">
                        <a href="${pageContext.request.contextPath}/detail/${board.id}" style="text-decoration: none;">
                            <div class="post-content">
                                <h3>${board.title}</h3>
                                <p>${board.content}</p>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
