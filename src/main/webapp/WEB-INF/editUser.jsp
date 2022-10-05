<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe EE | Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-form">
    <h1 class="text-white">Edit your account</h1>
    <div class="row bg-light p-4 rounded">
        <form class="d-flex flex-column align-items-center justify-content-center" action="${pageContext.request.contextPath}/auth/edit-user" method="POST">
            <input hidden name="idUser" value="${user.id}">
            <div class="form-group mb-2 w-100">
            <label for="firstName">First name</label>
            <input id="firstName" class="form-control" type="text" name="firstName" value="${user.firstName}">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="lastName">Last name</label>
            <input id="lastName" class="form-control" type="text" name="lastName" value="${user.lastName}">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="pictureUrl">Picture</label>
            <input id="pictureUrl" class="form-control" type="text" name="pictureUrl" value="${user.pictureUrl}">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="email">Email</label>
            <input id="email" class="form-control" type="text" name="email" value="${user.email}">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="password">Password</label>
            <input id="password" class="form-control" type="password" name="password" value="${user.password}">
            </div>
            <div class="col text-center mt-2">
            <button class="btn btn-primary" type="submit">Edit my account</button>
            </div>
        </form>

    </div>

</div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
