<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8”>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/style.css"/>
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Demo JSP</title>
</head>
<body>
<h1>Hello World</h1>
<div class=>
<p>In <c:out value="${num}"></c:out> years, you will
    live in <c:out value="${city}"></c:out> with
    <c:out value="${person}"></c:out> as your
    roommate, <c:out value="${hobby}"></c:out> for a living.
    The next time you
    see a  <c:out value="${thing}"></c:out>, you will
    have good luck.
    Also,  <c:out value="${something}"></c:out>.</p>
    <p>
        <a href="/">Go Back</a>
    </p>
</div>
</body>
</html>
