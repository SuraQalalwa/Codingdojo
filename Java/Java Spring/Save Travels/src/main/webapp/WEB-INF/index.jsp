<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<h1>Save Travels</h1>
<table class="table col-6">
    <thead>
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="travel" items="${travels}">
        <tr>
            <td><a href="/travel/${travel.id}"><c:out value="${travel.expense}"></c:out><a/></td>
            <td><c:out value="${travel.vendor}"></c:out></td>
            <td>$ <c:out value="${travel.amount}"></c:out></td>
            <td><a href="/travels/${travel.id}/edit">edit</a>
            <td><form action="/${travel.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
        </form></td>
        </tr>
    </c:forEach>
    <!-- loop over all the books to show the details as in the wireframe! -->
    </tbody>
</table>
<h1>Add an Expense</h1>
<table class="table col-6">
<%--@elvariable id="travel" type=""--%>
<%--    modelAttribute="travel" to connect between the fron and back end--%>
<form:form action="/travels" method="post" modelAttribute="travel">
    <div>
        <form:label path="expense">Expense Name</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </div>
    <div>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </div>
    <div>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount" />
    </div>
    <input type="submit" value="Submit"/>
</form:form>
</table>
</body>
</html>
