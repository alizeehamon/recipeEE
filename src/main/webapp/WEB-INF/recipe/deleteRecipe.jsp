<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Confirmation : delete a recipe</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <jsp:include page="../header.jsp"></jsp:include>
  <style>
    <%@include file="/WEB-INF/css/style.css" %>
  </style>
</head>
<body>

<div class="container-form">
  <h4 class="text-center text-uppercase text-white">Do you really want to delete this recipe ?</h4>
  <div class="bg-light rounded p-4 w-20">
    <form action="${pageContext.request.contextPath}/auth/delete-recipe" method="post">
      <input hidden name="recipeId" value="${recipeId}">
      <button class="btn btn-primary mt-2" type="submit">Yes</button>
    </form>

    <form action="${pageContext.request.contextPath}/recipes-list" method="get">
      <button class="btn btn-danger mt-2" type="submit">No</button>
    </form>
  </div>
</div>
</div>
</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>

