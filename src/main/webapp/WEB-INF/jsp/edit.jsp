<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form method="POST" action="/submit" modelAttribute="task">
    <br/>
    <form:input id="Title" path="title"/>
    <label for="title">Title</label>
    <br/>
    <form:select id="Priority" path="priority">
        <form:option value="" label="----SELECT----"/>
        <form:options items="${priorities}"/>
    </form:select>
    <label for="Priority">Priority</label>
    <br/>
    <form:hidden path="id"/>
    <input type="submit">
</form:form>

</body>
</html>
