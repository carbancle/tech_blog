<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
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
        .logo {
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
        .user-info-container {
            background-color: #ffffff;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            margin-top: 50px; /* Add some margin to separate from the header */
        }
        h2 {
            color: #333333;
            margin-bottom: 20px;
        }
        p {
            color: #666666;
            margin: 10px 0;
            font-size: 16px;
        }
        .logout {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .logout:hover {
            background-color: #c82333;
            transition: 0.6s;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="user-info-container">
        <h2>사용자 정보</h2>
        <p>아이디: ${user.userId}</p>
        <p>이름: ${user.username}</p>
        <p>이메일: ${user.email}</p>
        <a href="${pageContext.request.contextPath}/logout" class="logout">로그아웃</a>
    </div>
</body>
</html>
