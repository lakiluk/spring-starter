<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title></title>
</head>
<body>

<spring:message code="select" var="emptySelect" />
<spring:message code="submit" var="submit" />

<form:form method="POST" action="/submit" modelAttribute="task">
    <br/>
    <label for="title"><spring:message code="task.title"/></label>
    <form:input id="Title" path="title"/>
    <br/>
    <label for="Priority"><spring:message code="task.priority"/></label>
    <form:select id="Priority" path="priority">
        <form:option value="" label="${emptySelect}"/>
        <form:options items="${priorities}"/>
    </form:select>
    <br/>
    <form:hidden path="id"/>
    <input type="submit" value="${submit}">
</form:form>

</body>
</html>
