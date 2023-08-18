<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action='<c:url value="/login"></c:url>' method="POST">
        <input type="text" name="email" placeholder="Enter your email"
            required />
        <br>
        <br>
        <input type="password" name="password"
            placeholder="Enter your password" required />
        <br>
        <br>
        <button>Log in</button>
    </form>
    <c:if test="${loginFailed == true}">
        <br>
        <p style="color: red;">Login failed! Please try again.</p>
    </c:if>
</body>
</html>