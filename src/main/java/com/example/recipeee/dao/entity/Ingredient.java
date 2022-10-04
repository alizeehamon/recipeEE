package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "picture_url")
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

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(that.pictureUrl) : that.pictureUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        return result;
    }

    public Collection<IngredientRecipe> getIngredientRecipesById() {
        return ingredientRecipesById;
    }

    public void setIngredientRecipesById(Collection<IngredientRecipe> ingredientRecipesById) {
        this.ingredientRecipesById = ingredientRecipesById;
    }
}
