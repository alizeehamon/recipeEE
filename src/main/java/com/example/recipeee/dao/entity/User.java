package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "picture_url", nullable = true, length = 255)
    private String pictureUrl;
    @OneToMany(mappedBy = "userByIdUser")
    private Collection<RecipeUser> recipeUsersById;

    public User(String firstName, String lastName, String pictureUrl, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pictureUrl = pictureUrl;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(pictureUrl, user.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, pictureUrl);
    }

    public Collection<RecipeUser> getRecipeUsersById() {
        return recipeUsersById;
    }

    public void setRecipeUsersById(Collection<RecipeUser> recipeUsersById) {
        this.recipeUsersById = recipeUsersById;
    }
}
