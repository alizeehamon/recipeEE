package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Recipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "difficulty", nullable = true)
    private Integer difficulty;
    @Basic
    @Column(name = "pictureUrl", nullable = true, length = 255)
    private String pictureUrl;
    @Basic
    @Column(name = "cook_time", nullable = true)
    private Integer cookTime;
    @Basic
    @Column(name = "preparation", nullable = true)
    private Integer preparation;
    @Basic
    @Column(name = "rest_time", nullable = true)
    private Integer restTime;
    @Basic
    @Column(name = "expanse", nullable = true)
    private Integer expanse;
    @Basic
    @Column(name = "cook_type", nullable = true, length = 255)
    private String cookType;
    @OneToMany(mappedBy = "recipeByIdRecipe")
    private Collection<IngredientRecipe> ingredientRecipesById;
    @ManyToOne
    @JoinColumn(name = "id_step", referencedColumnName = "id")
    private Step stepByIdStep;
    @ManyToOne
    @JoinColumn(name = "id_type_meal", referencedColumnName = "id")
    private TypeMeal typeMealByIdTypeMeal;
    @OneToMany(mappedBy = "recipeByIdRecipe")
    private Collection<RecipeUser> recipeUsersById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getPreparation() {
        return preparation;
    }

    public void setPreparation(Integer preparation) {
        this.preparation = preparation;
    }

    public Integer getRestTime() {
        return restTime;
    }

    public void setRestTime(Integer restTime) {
        this.restTime = restTime;
    }

    public Integer getExpanse() {
        return expanse;
    }

    public void setExpanse(Integer expanse) {
        this.expanse = expanse;
    }

    public String getCookType() {
        return cookType;
    }

    public void setCookType(String cookType) {
        this.cookType = cookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(difficulty, recipe.difficulty) && Objects.equals(pictureUrl, recipe.pictureUrl) && Objects.equals(cookTime, recipe.cookTime) && Objects.equals(preparation, recipe.preparation) && Objects.equals(restTime, recipe.restTime) && Objects.equals(expanse, recipe.expanse) && Objects.equals(cookType, recipe.cookType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, difficulty, pictureUrl, cookTime, preparation, restTime, expanse, cookType);
    }

    public Collection<IngredientRecipe> getIngredientRecipesById() {
        return ingredientRecipesById;
    }

    public void setIngredientRecipesById(Collection<IngredientRecipe> ingredientRecipesById) {
        this.ingredientRecipesById = ingredientRecipesById;
    }

    public Step getStepByIdStep() {
        return stepByIdStep;
    }

    public void setStepByIdStep(Step stepByIdStep) {
        this.stepByIdStep = stepByIdStep;
    }

    public TypeMeal getTypeMealByIdTypeMeal() {
        return typeMealByIdTypeMeal;
    }

    public void setTypeMealByIdTypeMeal(TypeMeal typeMealByIdTypeMeal) {
        this.typeMealByIdTypeMeal = typeMealByIdTypeMeal;
    }

    public Collection<RecipeUser> getRecipeUsersById() {
        return recipeUsersById;
    }

    public void setRecipeUsersById(Collection<RecipeUser> recipeUsersById) {
        this.recipeUsersById = recipeUsersById;
    }
}
