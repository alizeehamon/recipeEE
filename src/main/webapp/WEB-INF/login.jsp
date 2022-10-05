<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Recipe EE | Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="form-group d-flex flex-column align-items-center">
            <h4 class="text-center text-uppercase">Login page</h4>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="email" class="form-control-sm" name="email" id="email" placeholder="email" required/><br>
                <input type="password" class="form-control-sm" name="password" id="password" placeholder="password" required/><br>
                <div class="col text-center">
                    <button type="submit" class="btn btn-primary mt-2">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
