<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product & Categories</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="js/app.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<h1>Home Page</h1>
<a href="/product/new">New Product</a>
<a href="/category/new">New Category</a>
<table class="table col-5">
    <thead>
    <tr>
        <th>Product</th>
        <th>Category</th>

    </tr>
    </thead>
    <tbody>


        <tr>

            <td>
                <c:forEach var="product" items="${products}">
                <a href="/product/${product.id}"><c:out value="${product.name}"></c:out><a/>
                    </c:forEach>
            </td>



            <td>
                <c:forEach var="category" items="${categories}">
                <a href="/category/${category.id}"><c:out value="${category.name}"></c:out><a/>
                    </c:forEach>
                    </td>
        </tr>

    </tbody>
</table>
</body>
</html>
