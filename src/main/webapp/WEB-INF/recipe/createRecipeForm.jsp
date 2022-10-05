<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe EE | Join</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">

    <h1>Create your recipe</h1>

    <div class="row">

        <form action="${pageContext.request.contextPath}/auth/recipe/add-recipe" method="POST">

            <label for="recipeName">Recipe name</label>
            <input id="recipeName" type="text" name="recipeName">

            <label for="difficulty">Difficulty</label>
            <input id="difficulty" type="number" name="difficulty">

            <label for="pictureUrl">Recipe picture</label>
            <input id="pictureUrl" type="text" name="pictureUrl">

            <label for="cookTime">Cook time in min</label>
            <input id="cookTime" type="number" name="cookTime">

            <label for="preparation">Preparation time in min</label>
            <input id="preparation" type="number" name="preparation">

            <label for="restTime">Rest time in min</label>
            <input id="restTime" type="number" name="restTime">

            <label for="expanse">Expanse</label>
            <input id="expanse" type="number" name="expanse">

            <label for="cookType">Cook Type</label>
            <input id="cookType" type="text" name="cookType">

            <label for="mealType">Meal Type</label>
            <input id="mealType" name="typeMeal" type="text" list="mealTypes" />
            <datalist id="mealTypes">
                <c:forEach items="${typeMeals}" var="typeMeal">
                    <option value="${typeMeal.name}">${typeMeal.name}</option>
                </c:forEach>
            </datalist>

            <button type="submit">Create a recipe</button>
        </form>

    </div>

</div>

</body>
</html>

