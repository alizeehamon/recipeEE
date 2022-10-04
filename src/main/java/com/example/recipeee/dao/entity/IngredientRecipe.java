package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient_recipe", schema = "recipeee")
public class IngredientRecipe {
    @Basic
    @Column(name = "qty_ingredient")
    private int qtyIngredient;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_recipe", referencedColumnName = "id", nullable = false)
    private Recipe recipeByIdRecipe;
    @ManyToOne
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id", nullable = false)
    private Ingredient ingredientByIdIngredient;

    public int getQtyIngredient() {
        return qtyIngredient;
    }

    public void setQtyIngredient(int qtyIngredient) {
        this.qtyIngredient = qtyIngredient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientRecipe that = (IngredientRecipe) o;

        if (qtyIngredient != that.qtyIngredient) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qtyIngredient;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    public Recipe getRecipeByIdRecipe() {
        return recipeByIdRecipe;
    }

    public void setRecipeByIdRecipe(Recipe recipeByIdRecipe) {
        this.recipeByIdRecipe = recipeByIdRecipe;
    }

    public Ingredient getIngredientByIdIngredient() {
        return ingredientByIdIngredient;
    }

    public void setIngredientByIdIngredient(Ingredient ingredientByIdIngredient) {
        this.ingredientByIdIngredient = ingredientByIdIngredient;
    }
}
