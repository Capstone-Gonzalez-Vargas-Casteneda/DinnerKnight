package com.example.dinnerknight.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String eventDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Event(){}

    public Event(Event copy){
        this.name = copy.name;
        this.address = copy.address;
        this.description = copy.description;
        this.eventDate = copy.eventDate;
        this.owner = copy.owner;
        this.food = copy.food;
    }

    public Event(long id, String name, String address,String eventDate, String description, User owner, Food food) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.eventDate = eventDate;
        this.description = description;
        this.owner = owner;
        this.food = food;
    }

    public Event( String name, String address,String eventDate, String description, User owner, Food food) {
        this.name = name;
        this.address = address;
        this.eventDate = eventDate;
        this.description = description;
        this.owner = owner;
        this.food = food;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
