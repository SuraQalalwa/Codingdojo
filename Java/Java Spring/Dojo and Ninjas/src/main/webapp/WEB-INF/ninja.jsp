<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dojo And Ninja</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>Dojo And Ninja</h1>
<div>
    <%--@elvariable id="ninja" type=""--%>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <div>
            <form:select path="dojo">
                <c:forEach var="dojos" items="${dojos }">
                    <option value="${dojos.id }">${dojos.name }</option>
                </c:forEach>
            </form:select>
        </div>
        <div>
            <form:label path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </div>
        <div>
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </div>
        <div>
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input path="age" />
        </div>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
