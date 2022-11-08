<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>${products.name}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<h1>${products.name}</h1>
<a href="/">Home Page</a>


<ul>
    <li>${products.name}</li>
</ul>
<ul>
    <form action="/product/${id}" method="post">
        <li>
            <c:forEach var="catpro" items="${catpro}">
                <c:out value="${catpro.name}"></c:out>
            </c:forEach>
        </li>
    </form>
</ul>
<h3>Add Category</h3>
<form action="/product/${id}" method="post">
    <select name="categoryId">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input class="input" class="button" type="submit" value="Add"/>
</form>
</body>
</html>