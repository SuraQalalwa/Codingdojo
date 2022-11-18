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
</head>
<body>
<a href="/songs/new"> Add Song</a>
<a href="/TopTen"> Top Song</a>
<form action='/show' method="post">
    <input type="text" placeholder="text" name="artist">
    <input type="submit">
</form>



<table class="table col-6">
    <thead>
    <tr>
        <th>Name</th>
        <th>rating</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="song" items="${songs}">
        <tr>
            <td><a href="/song/${song.id}"><c:out value="${song.title}"></c:out><a/></td>
            <td><c:out value="${song.rating}"></c:out></td>
            <td>actions</td>
            </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
