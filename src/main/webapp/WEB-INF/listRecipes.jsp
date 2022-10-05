<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Recipe EE | List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <c:forEach items="${recipes}" var="recipe">
            <div class="card col-3">
                <img class="card-img-top" src="${recipe.pictureUrl}" alt="${recipe.name}">
                <div class="card-body">
                    <h5 class="card-title">${recipe.name}</h5>
                    <a href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Afficher la recette</a>
                </div>
            </div>
        </c:forEach>

    <form action="${pageContext.request.contextPath}/recipes-list" method="POST">
    <label for="site-search">Search recipes by name:</label>
    <input type="searchName" id="site-search" name="searchName">

    <label for="mealType-select">Choose a type of meal:</label>
    <select name="mealType" id="mealType-select">
        <option value="">--Please choose a meal type--</option>
        <c:forEach items="${mealTypes}" var="mealType"><option value="${mealType.id}">${mealType.name}</option></c:forEach>
    </select>
    <button>Search</button>
    </form>
    </div>
</div>
</body>
</html>
