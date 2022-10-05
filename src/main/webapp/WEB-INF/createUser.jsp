<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe EE | Join</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-form">

    <h1 class="text-white">Create your account</h1>

    <div class="row bg-light p-4 rounded">

        <form class="d-flex flex-column align-items-center justify-content-center" action="${pageContext.request.contextPath}/add-user" method="POST">
            <div class="form-group mb-2 w-100">
            <label for="firstName">First name</label>
            <input class="form-control" id="firstName" type="text" name="firstName">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="lastName">Last name</label>
            <input class="form-control" id="lastName" type="text" name="lastName">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="pictureUrl">Picture</label>
            <input class="form-control" id="pictureUrl" type="text" name="pictureUrl">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="email">Email</label>
            <input class="form-control" id="email" type="text" name="email">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="password">Password</label>
            <input class="form-control" id="password" type="password" name="password">
            </div>
            <button class="btn btn-primary" type="submit">Create an account</button>
        </form>

    </div>

</div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
