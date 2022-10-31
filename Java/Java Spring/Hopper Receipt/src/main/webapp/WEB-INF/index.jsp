<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>User</title>
</head>
<body>
<h1>Customer Name:<c:out value="${firstname}"></c:out><c:out value="${lastname}"></c:out> </h1>
<p>Item name:<c:out value="${Itemname}"></c:out></p>
<p>Price: $<c:out value="${price}"></c:out></p>
<p>Description:<c:out value="${desc}"></c:out></p>
<p>Vendor:<c:out value="${vendor}"></c:out></p>

</body>
</html>
