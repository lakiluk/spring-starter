<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<c:url value="/j_spring_security_check" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <div>
        <label for="login">Login</label>
        <input name="username" id="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input name="password" id="password"/>
    </div>
    <input type="submit" value="submit">
</form>
</body>
</html>
