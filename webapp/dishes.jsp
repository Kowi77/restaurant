<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dishes list</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="index.html">Main page</a></h3>
    <h2>Dishes</h2>

    <hr/>
    <a href="dishes?action=create">Add Dish</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <c:forEach items="${dishes}" var="dish">
            <jsp:useBean id="dish" scope="page" type="main.model.Dish"/>
            <tr>
                <td>${dish.description}</td>
                <td>${dish.price}</td>
                <td><a href="dishes?action=update&id=${dish.id}">Update</a></td>
                <td><a href="dishes?action=delete&id=${dish.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
