<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<header class="bg-danger mb-4 shadow">
    <nav class="navbar navbar-expand-lg navbar-danger bg-danger p-3">

        <a class="navbar-brand" href="${pageContext.request.contextPath}/recipes-list">
            <img src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/100.png" alt="logo RecipeEE">
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/recipes-list">Home</a>
                </li>

                <!-- peut etre a revoir /  comment on passe l'id probablement stocker l'utilisateur dans la session -->
                <!-- search bar possiblement ajoutable dans le <if> ci-dessous -->
                <c:if test="${not empty sessionScope.user}">
                    <!-- randomise recipe -->
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="#">Get a random recipe</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white"
                           href="${pageContext.request.contextPath}/edit-user?id=${user.id}">My profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/auth/logout">Logout</a>
                    </li>
                </c:if>

                <!-- Bloc login / Sign in-->
                <c:if test="${empty sessionScope.username}">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/add-user">Sign in</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

</html>
