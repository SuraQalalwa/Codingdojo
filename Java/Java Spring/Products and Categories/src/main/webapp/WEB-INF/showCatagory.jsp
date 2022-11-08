<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>${categories.name}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<h1>${categories.name}</h1>
<a href="/">Home Page</a>

<ul>
    <form action="/category/${id}" method="post">
        <li>
            <c:forEach var="procat" items="${procat}">
                <c:out value="${procat.name}"></c:out>
            </c:forEach>
        </li>
    </form>
</ul>
<h3>Add Product</h3>
        <form action="/category/${id}" method="post">
            <select name="productId">
                <c:forEach var="product" items="${products}">
                    <option value="${product.id}">${product.name}</option>
                </c:forEach>
            </select>
            <input class="input" class="button" type="submit" value="Add"/>
</form>
</body>
</html>