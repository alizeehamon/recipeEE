<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : log out</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <jsp:include page="header.jsp"></jsp:include>

</head>
<body>

<div class="container">
    <h4 class="text-center  text-uppercase">Do you really want to log out ?</h4>

    <form action="${pageContext.request.contextPath}/auth/logout" method="post">
        <button class="btn-card mt-2" type="submit">Yes</button>
    </form>

    <form action="${pageContext.request.contextPath}/recipes-list" method="get">
        <button class="btn-del mt-2" type="submit">No</button>
    </form>
</div>
</body>
</html>

