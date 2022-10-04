<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recette :${recipe.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="card w-50">
            <img class="card-img-top" src="${recipe.pictureUrl}" alt="${recipe.name}">
            <div class="card-body">
                <h5 class="card-title text-center">${recipe.name}</h5>
                <div class="d-flex flex-row justify-content-around">
                    <div>
                        <img src="" alt="cuisson">
                        <span>${recipe.cookTime}</span>
                    </div>
                    <div>
                        <img src="" alt="difficulty">
                        <span>${recipe.difficulty}</span>
                    </div>
                    <div>
                        <img src="" alt="expansiveness">
                        <span>${recipe.expanse}</span>
                    </div>
                </div>
            </div>
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

            <p>Etapes à suivre : </p>
            <ul class="list-group list-group-flush">

                <%--
                affichage des étapes
                <c:forEach items="${steps}" var="step">
                    <li>
                        ${step.description}
                    </li>
                </c:forEach>
                --%>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
