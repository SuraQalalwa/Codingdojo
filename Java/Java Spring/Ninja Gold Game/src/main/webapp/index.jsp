<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Ninja Gold Game</title>
</head>
<body>
<h3>Your Gold:<span>${gold}</span></h3>
<div>
    <h3>Farm</h3>
    <h3>(earns 10-20 gold)</h3>
    <form action="/processMoney" method="POST">
        <input type="hidden" name="whichForm" value="farm">
        <input type="submit" value="Find Gold!">
    </form>
</div>
<div>
    <h3>Cave</h3>
    <h3>(earns 10-20 gold)</h3>
    <form action="/processMoney" method="POST">
        <input type="hidden" name="whichForm" value="cave">
        <input type="submit" value="Find Gold!">
    </form>
</div>
<div>
    <h3>House</h3>
    <h3>(earns 10-20 gold)</h3>
    <form action="/processMoney" method="POST">
        <input type="hidden" name="whichForm" value="house">
        <input type="submit" value="Find Gold!">
    </form>
</div>
<div>
    <h3>Quest</h3>
    <h3>(earns/takes 0-50 gold)</h3>
    <form action="/processMoney" method="POST">
        <input type="hidden" name="whichForm" value="quest">
        <input type="submit" value="Find Gold!">
    </form>
</div>
<div>
    <h3>Activities:</h3>
    <textarea name="activities" rows="6" cols="50" readonly>
        <c:forEach var="activity" items="${activities}">
        <c:out value="${activity}"></c:out>
        </c:forEach>
        </textarea>
</div>
</body>
</html>