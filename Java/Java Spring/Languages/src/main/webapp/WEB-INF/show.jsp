<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
<h2>Language Details</h2>
<a href="/languages">Dashboard</a>
<a><form action="/${language.id}/delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete"></a>
<p>Language Name: ${language.name}</p>
<p>Creator Name: ${language.creator}</p>
<p>Version: ${language.version}</p>
</body>
</html>
