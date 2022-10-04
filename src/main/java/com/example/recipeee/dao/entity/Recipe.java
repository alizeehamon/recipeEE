package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Recipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "difficulty")
    private Integer difficulty;
    @Basic
    @Column(name = "pictureUrl")
    private String pictureUrl;
    @Basic
    @Column(name = "cook_time")
    private Integer cookTime;
    @Basic
    @Column(name = "preparation")
    private Integer preparation;
    @Basic
    @Column(name = "rest_time")
    private Integer restTime;
    @Basic
    @Column(name = "expanse")
    private Integer expanse;
    @Basic
    @Column(name = "cook_type")
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

        if (id != recipe.id) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (difficulty != null ? !difficulty.equals(recipe.difficulty) : recipe.difficulty != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(recipe.pictureUrl) : recipe.pictureUrl != null) return false;
        if (cookTime != null ? !cookTime.equals(recipe.cookTime) : recipe.cookTime != null) return false;
        if (preparation != null ? !preparation.equals(recipe.preparation) : recipe.preparation != null) return false;
        if (restTime != null ? !restTime.equals(recipe.restTime) : recipe.restTime != null) return false;
        if (expanse != null ? !expanse.equals(recipe.expanse) : recipe.expanse != null) return false;
        if (cookType != null ? !cookType.equals(recipe.cookType) : recipe.cookType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + (cookTime != null ? cookTime.hashCode() : 0);
        result = 31 * result + (preparation != null ? preparation.hashCode() : 0);
        result = 31 * result + (restTime != null ? restTime.hashCode() : 0);
        result = 31 * result + (expanse != null ? expanse.hashCode() : 0);
        result = 31 * result + (cookType != null ? cookType.hashCode() : 0);
        return result;
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
