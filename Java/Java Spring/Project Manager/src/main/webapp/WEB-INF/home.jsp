<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Main Page</title>
</head>
<body>
<h1>Welcome, ${currentUser.userName}</h1>

<h4>All Projects</h4>
<table class="table">
    <thead>
    <tr>

        <th scope="col">Project</th>
        <th scope="col">Team Lead</th>
        <th scope="col">Due Date</th>
        <th scope="col">Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${userNotLeader}">
        <tr>
            <c:if test="${project.teamlead.id != currentUser.id}">
            <td><a href="/showproject/${project.id}">${project.title}</a></td>
            <td>${project.teamlead.userName}</td>
            <td>${project.duedate}</td>
            <td><a href="/projects/join/${project.id}">Join Team</a></td>
            </c:if>
        </tr>
    </c:forEach>


    </tbody>
</table>
<h4>Your Projects</h4>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Project</th>
        <th scope="col">Lead</th>
        <th scope="col">Due Date</th>
        <th scope="col">Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="userp" items="${userLeader}">
        <tr>
            <td><a href="/showproject/${userp.id}">${userp.title}</a></td>
            <td>${userp.teamlead.userName}</td>
            <td>${userp.duedate}</td>
            <c:choose>
            <c:when test="${userp.teamlead.id == currentUser.id}">
            <td><a href="/projects/edit/${userp.id}">Edit</a></td>
            </c:when>
            <c:otherwise>
            <td><a href="/projects/leave/${userp.id}">Leave Team</a></td>
            </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/logout">Log Out</a>
<a href="/projects/new">+ new Project</a>
</body>
</html>
/// validation when adding project
/// edit does not work
