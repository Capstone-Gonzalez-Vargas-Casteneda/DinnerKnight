package com.example.dinnerknight.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isCook;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "food_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_id")}
    )
    private List<Food> foods;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pack_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "pack_id")}
    )
    private List<Pack> packs;


    public User() {
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        firstName = copy.firstName;
        lastName = copy.lastName;
        password = copy.password;
        isCook = copy.isCook;
    }

    public User(long id, String email, String username, String firstName, String lastName, String password, boolean isCook, List<Food> foods) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isCook = isCook;
        this.foods = foods;
    }

    public User(long id, String username, boolean isCook, List<Food> foods) {
        this.id = id;
        this.username = username;
        this.isCook = isCook;
        this.foods = foods;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCook() {
        return isCook;
    }

    public void setCook(boolean cook) {
        isCook = cook;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
