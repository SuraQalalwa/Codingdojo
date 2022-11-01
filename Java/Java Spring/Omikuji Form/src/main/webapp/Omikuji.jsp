<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Omikuji</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>Send A Omikuji</h1>
<div>
<form action="/show" method="post">
    <label>Pick any number from 5 to 25</label> <br>
<select name="num">..
    <%for(int i=5; i<=25; i++){%>
    <option><%= i %></option>
    <%}%>
</select> <br>
<label>Enter the name of any city. </label>
<input type="text" name='city'>
<label>Enter the name of any real person. </label>
<input type="text" name='person'>
<label>Enter proffessional endeavor or hobby.</label>
<input type="text" name='hobby'>
<label>Enter any type of living thing</label>
<input type="text" name='thing'>
    <label>Say Someting nice to someone: </label>
<textarea name="something" rows="4" cols="50">
</textarea>
<p>Send and show a friend!</p>
<input type='submit' id="submit" value='send' class="btn btn-primary">
</form>
</div>
</body>
</html>
