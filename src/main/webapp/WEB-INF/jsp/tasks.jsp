<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks list</title>
    <link rel="stylesheet" type="text/css" href="../../css/webapp.css">
</head>
<body>
<h1>Tasks</h1>
<table class="tasksTable">
    <tbody>
    <c:if test="${not empty tasks}">
        <tr>
            <td >Task id</td>
            <td>Task title</td>
            <td>Task priority</td>
            <td>&nbsp;</td>
        </tr>
    </c:if>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${priorities.get(task.priority)}</td>
            <td><a href="/edit?id=${task.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="add">Add</a>
</body>
</html>
