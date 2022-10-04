<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe EE | Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <h1>Edit your account</h1>

    <div class="row">
        <form action="${pageContext.request.contextPath}/edit-user" method="POST">
            <input hidden name="idUser" value="${user.id}">
            <label for="firstName">First name</label>
            <input id="firstName" type="text" name="firstName" value="${user.firstName}">

            <label for="lastName">Last name</label>
            <input id="lastName" type="text" name="lastName" value="${user.lastName}">

            <label for="pictureUrl">Picture</label>
            <input id="pictureUrl" type="text" name="pictureUrl" value="${user.pictureUrl}">

            <label for="email">Email</label>
            <input id="email" type="text" name="email" value="${user.email}">

            <label for="password">Password</label>
            <input id="password" type="password" name="password" value="${user.password}">

            <button type="submit">Edit my account</button>
        </form>

    </div>

</div>

</body>
</html>
