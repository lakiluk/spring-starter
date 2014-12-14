<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
This is home page! You're authenticated as ${pageContext.request.userPrincipal.name}
<br/>
You're authenticated with role:
<ul>
    <security:authorize access="hasRole('ADMIN')">
        <li>admin</li>
    </security:authorize>
    <security:authorize access="hasRole('USER')">
        <li>user</li>
    </security:authorize>
</ul>

<c:url var="adminPage" value="/admin"/>
<security:authorize access="hasRole('ADMIN')">
    <a href="${adminPage}">Go to Admin Page</a>
</security:authorize>

<br/>

<c:url var="logout" value="/logout"/>
<a href="${logout}">Logout</a>

</body>
</html>
