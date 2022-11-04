<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <%--    <script type="text/javascript" src="js/app.js"></script>--%>
</head>
<body>
<h1>Save Travels</h1>
<table class="table col-6">
    <thead>
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="travel" items="${travels}">
        <tr>
            <td><c:out value="${travel.expense}"></c:out></td>
            <td><c:out value="${travel.vendor}"></c:out></td>
            <td>$ <c:out value="${travel.amount}"></c:out></td>
        </tr>
    </c:forEach>

    <!-- loop over all the books to show the details as in the wireframe! -->
    </tbody>
    <form method="post" action="/addtravel">
        <label>Expense Name</label>
        <input type="text" name="expense" value="${travel.expense}">
        <label>Vendor</label>
        <input type="text" name="expense" value="${travel.vendor}">
        <label>Amount</label>
        <input type="text" name="expense" value="${travel.amount}">
        <input type="submit" value="Submit">
    </form>

</table>


</body>
</html>
