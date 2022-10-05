<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="${pageContext.request.contextPath}/add-ingredient" method="post">
    <div class="mb-3 mt-3">
        <input hidden name="idRecipe" value="${param.idRecipe}">
        <label for="ingredientName" class="form-label">Ingredient name:</label>
        <input type="text" class="form-control" id="ingredientName" placeholder="Enter ingredient name" name="ingredientName">
        <label for="ingredientUrl" class="form-label">Ingredient photo url:</label>
        <input type="text" class="form-control" id="ingredientUrl" placeholder="Enter ingredient photo url" name="ingredientUrl">
        <label for="qtyIngredient" class="form-label">Ingredient quantity:</label>
        <input type="number" class="form-control" id="qtyIngredient" placeholder="Enter ingredient quantity" name="qtyIngredient">
    </div>
    <button type="submit" class="btn btn-primary">Submit step</button>
</form>