<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
    <h2>User Information</h2>
    <p>UserId: ${user.userId }</p>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>