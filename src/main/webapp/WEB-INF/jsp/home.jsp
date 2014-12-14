<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
This is home page! You're authenticated as ${pageContext.request.userPrincipal.name}
<br/>
You're authenticated with role:
<ul>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <li>admin</li>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_USER')">
        <li>user</li>
    </security:authorize>
</ul>

<br/>

<c:url var="logout" value="/logout"/>
<a href="${logout}">Logout</a>

</body>
</html>
