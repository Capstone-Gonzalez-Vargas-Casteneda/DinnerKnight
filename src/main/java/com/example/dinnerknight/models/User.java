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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Food> foods;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private List<Event> events;


    public User() {
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        firstName = copy.firstName;
        lastName = copy.lastName;
        password = copy.password;
        events = copy.events;
        foods = copy.foods;
    }

    public User(long id, String email, String username, String firstName, String lastName, String password, List<Food> foods,List<Event> events) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.foods = foods;
        this.events = events;
    }

    public User( String email, String username, String firstName, String lastName,String password) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(long id, String username, List<Food> foods) {
        this.id = id;
        this.username = username;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public List<Event> getEvents(){
        return events;
    }
}
