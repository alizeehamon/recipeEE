package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "recipe_user", schema = "recipeee")
public class RecipeUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "cook_date", nullable = false)
    private Date cookDate;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User userByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_recipe", referencedColumnName = "id", nullable = false, unique=true)
    private Recipe recipeByIdRecipe;

    public RecipeUser() {
    }

    public RecipeUser(String cookDate, User userByIdUser, Recipe recipeByIdRecipe) {
        this.cookDate = Date.valueOf(cookDate);
        this.userByIdUser = userByIdUser;
        this.recipeByIdRecipe = recipeByIdRecipe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCookDate() {
        return cookDate;
    }

    public void setCookDate(Date cookDate) {
        this.cookDate = cookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeUser that = (RecipeUser) o;
        return id == that.id && Objects.equals(cookDate, that.cookDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cookDate);
    }

    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    public Recipe getRecipeByIdRecipe() {
        return recipeByIdRecipe;
    }

    public void setRecipeByIdRecipe(Recipe recipeByIdRecipe) {
        this.recipeByIdRecipe = recipeByIdRecipe;
    }
}
