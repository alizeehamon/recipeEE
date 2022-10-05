<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="${pageContext.request.contextPath}/step/add-step" method="post">
    <div class="mb-3 mt-3">
        <input hidden name="idRecipe" value="${param.idRecipe}">
        <label for="stepDescription" class="form-label">Description:</label>
        <input type="text" class="form-control" id="stepDescription" placeholder="Enter step description" name="stepDescription">
    </div>
    <button type="submit" class="btn btn-primary">Submit step</button>
</form>