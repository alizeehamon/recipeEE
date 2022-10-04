package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "recipe_user", schema = "recipeee", catalog = "")
public class RecipeUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "cook_date")
    private Date cookDate;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User userByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_recipe", referencedColumnName = "id", nullable = false)
    private Recipe recipeByIdRecipe;

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

        if (id != that.id) return false;
        if (cookDate != null ? !cookDate.equals(that.cookDate) : that.cookDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cookDate != null ? cookDate.hashCode() : 0);
        return result;
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
