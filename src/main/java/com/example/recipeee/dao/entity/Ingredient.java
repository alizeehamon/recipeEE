package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "picture_url", nullable = true, length = 255)
    private String pictureUrl;
    @OneToMany(mappedBy = "ingredientByIdIngredient")
    private Collection<IngredientRecipe> ingredientRecipesById;

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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(pictureUrl, that.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pictureUrl);
    }

    public Collection<IngredientRecipe> getIngredientRecipesById() {
        return ingredientRecipesById;
    }

    public void setIngredientRecipesById(Collection<IngredientRecipe> ingredientRecipesById) {
        this.ingredientRecipesById = ingredientRecipesById;
    }
}
