<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/style.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h1>Fruit Store</h1>
    <table class="table col-6">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="fruite" items="${fruits}">
        <tr>
            <td><c:out value="${fruite.name}"></c:out></td>
            <td><c:out value="${fruite.price}"></c:out></td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
