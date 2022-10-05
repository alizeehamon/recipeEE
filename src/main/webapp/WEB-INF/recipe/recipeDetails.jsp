<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe EE | ${recipe.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="card p-0 w-50">
            <img class="card-img-top" src="${recipe.pictureUrl}" alt="${recipe.name}">
            <div class="card-body shadow container-fluid rounded d-flex flex-column ">
                <h5 class="card-title text-center mb-3">${recipe.name}</h5>
                <div class="d-flex flex-row justify-content-around align-items-center">
                    <div>
                        <img src="${pageContext.request.contextPath}/resources/185030_cook_pot_pan_icon%20(1).png"
                             alt="cuisson">
                        <span>${recipe.cookTime} min</span>
                    </div>
                    <i class="bi bi-dot">.</i>
                    <div>
                        <img src="${pageContext.request.contextPath}/resources/185114_chef_restaurant_food_icon.png"
                             alt="difficulty">
                        <span>${recipe.difficulty}</span>
                    </div>
                    <i class="bi bi-dot">.</i>
                    <div>
                        <img src="${pageContext.request.contextPath}/resources/2784258_business_coin_euro_finance_money_icon.png"
                             alt="expansiveness">
                        <span>${recipe.expanse}/5</span>
                    </div>
                </div>
            </div>
            <div class="card-body shadow-sm">
                <p>Liste des ingrédients : </p>
                <ul class="list-group list-group-flush">

                    <%--
                    affichage des étapes
                    <c:forEach items="${ingredients}" var="ingredient">
                        <li>
                            ${ingredient.name}
                            <img src="ingredient.pictureUrl"/>
                        </li>
                    </c:forEach>
                    --%>

                </ul>
            </div>
            <div class="card-body">
                <p>Etapes à suivre : </p>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${steps}" var="step">
                        <li class="list-group-item">
                            ${step.description}
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="card-footer">
                <a href="#addStep" class="btn btn-primary" data-bs-toggle="collapse">Add step</a>
                <div id="addStep" class="collapse">
                    <jsp:include page="../step/addStepForm.jsp">
                        <jsp:param name="idRecipe" value="${recipe.id}"/>
                    </jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
