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
<jsp:include page="../header.jsp"/>
<div class="container-form">

    <h1 class="text-white">Create your recipe</h1>

    <div class="row bg-light p-4 rounded mb-3">

        <form class="d-flex flex-column align-items-center justify-content-center" action="${pageContext.request.contextPath}/auth/recipe/add-recipe" method="POST">
            <div class="form-group mb-2 w-100">
            <label for="recipeName">Recipe name</label>
            <input class="form-control" id="recipeName" type="text" name="recipeName">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="difficulty">Difficulty</label>
            <input class="form-control" id="difficulty" type="number" name="difficulty">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="pictureUrl">Recipe picture</label>
            <input class="form-control" id="pictureUrl" type="text" name="pictureUrl">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="cookTime">Cook time in min</label>
            <input class="form-control" id="cookTime" type="number" name="cookTime">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="preparation">Preparation time in min</label>
            <input class="form-control" id="preparation" type="number" name="preparation">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="restTime">Rest time in min</label>
            <input class="form-control" id="restTime" type="number" name="restTime">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="expanse">Expanse</label>
            <input class="form-control" id="expanse" type="number" name="expanse">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="cookType">Cook Type</label>
            <input class="form-control" id="cookType" type="text" name="cookType">
            </div>
            <div class="form-group mb-2 w-100">
            <label for="mealType">Meal Type</label>
            <input class="form-control" id="mealType" name="typeMeal" type="text" list="mealTypes" />
            <datalist id="mealTypes">
                <c:forEach items="${typeMeals}" var="typeMeal">
                    <option value="${typeMeal.name}">${typeMeal.name}</option>
                </c:forEach>
            </datalist>
            </div>

            <button class="btn btn-primary" type="submit">Create a recipe</button>
        </form>

    </div>

</div>

</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>

