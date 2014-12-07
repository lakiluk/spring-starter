<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title><spring:message code="tasks.list"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/webapp.css">
</head>
<body>
<h1><spring:message code="tasks.list"/></h1>
<table class="tasksTable">
    <tbody>
    <c:if test="${not empty tasks}">
        <tr>
            <td><spring:message code="task.id"/></td>
            <td><spring:message code="task.title"/></td>
            <td><spring:message code="task.priority"/></td>
            <td>&nbsp;</td>
        </tr>
    </c:if>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${priorities.get(task.priority)}</td>
            <td><a href="/edit?id=${task.id}"><spring:message code="edit"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="add">Add</a>
</body>
</html>
