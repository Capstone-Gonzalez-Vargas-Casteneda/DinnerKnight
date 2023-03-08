package com.example.dinnerknight.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pack")
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private long cookId;

    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pack")
    private List<Event> events;

    @ManyToMany(mappedBy = "packs")
    private List<User> users;

    public Pack(){}

    public Pack(Pack copy){
        this.id = copy.id;
        this.name = copy.name;
        this.address = copy.address;
        this.cookId = copy.cookId;
        this.description = copy.description;
    }

    public Pack(long id, String name, String address, long cookId, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cookId = cookId;
        this.description = description;
    }

    public Pack(String name, String address, long cookId, String description) {
        this.name = name;
        this.address = address;
        this.cookId = cookId;
        this.description = description;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCookId() {
        return cookId;
    }

    public void setCookId(long cookId) {
        this.cookId = cookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
