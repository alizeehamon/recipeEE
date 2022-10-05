<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Recipe EE | Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <jsp:include page="header.jsp"></jsp:include>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<div class="container-form">
    <h1 class="text-white">Login</h1>
    <div class="row bg-light p-4 rounded">
            <form class="d-flex flex-column align-items-center justify-content-center" action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group mb-2 w-100">
                <input type="email" class="form-control-sm" name="email" id="email" placeholder="email" required/><br>
                </div>
                <div class="form-group mb-2 w-100">
                    <input type="password" class="form-control-sm" name="password" id="password" placeholder="password" required/><br>
                </div>
                    <div class="col text-center">
                    <button type="submit" class="btn btn-primary mt-2">Login</button>
                </div>
            </form>
        </div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
