<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <%--    <script type="text/javascript" src="js/app.js"></script>--%>
</head>
<body>
<h1>Edit language</h1>
<a href="/languages">Go Back</a>
<table class="table col-6">
        <%--@elvariable id="language" type=""--%>
        <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
            <input type="hidden" name="_method" value="put">

            <div>
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </div>
            <div>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </div>
            <div>
                <form:label path="version">Version</form:label>
                <form:errors path="version"/>
                <form:input path="version"/>
            </div>
            <input type="submit" value="Submit"/>
        </form:form>
</table>
</body>
</html>
