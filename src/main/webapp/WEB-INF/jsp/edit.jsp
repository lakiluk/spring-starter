<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../css/webapp.css">
</head>
<body>

<spring:message code="select" var="emptySelect"/>
<spring:message code="submit" var="submit"/>

<form:form method="POST" action="/submit" modelAttribute="task" cssClass="taskform">
    <div>
        <form:errors path="*">
            <div class="errorMessage"><spring:message code="formErrors"/></div>
        </form:errors>
    </div>
    <div>
        <label for="title"><spring:message code="task.title"/></label>
        <form:input id="Title" path="title"/>
        <br/>
        <form:errors cssClass="errorMessage" path="title"/>
    </div>
    <div>
        <label for="Priority"><spring:message code="task.priority"/></label>
        <form:select id="Priority" path="priority">
            <form:option value="" label="${emptySelect}"/>
            <form:options items="${priorities}"/>
        </form:select>
        <br/>
        <form:errors cssClass="errorMessage" path="priority"/>
    </div>
    <div>
        <input type="submit" value="${submit}">
    </div>
    <form:hidden path="id"/>
</form:form>

</body>
</html>
