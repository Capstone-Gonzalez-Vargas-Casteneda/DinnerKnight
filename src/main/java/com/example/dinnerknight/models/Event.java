package com.example.dinnerknight.models;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "pack_id")
    private Pack pack;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Event(){}

    public Event(Event copy){
        this.name = copy.name;
        this.address = copy.address;
        this.description = copy.description;
        this.pack = copy.pack;
        this.food = copy.food;
    }

    public Event(long id, String name, String address, String description, Pack pack, Food food) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.pack = pack;
        this.food = food;
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

    public Pack getGroup() {
        return pack;
    }

    public void setGroup(Pack pack) {
        this.pack = pack;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
