package com.example.dinnerknight.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private long cook_id;

    @Column(nullable = false)
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
//    private List<Event> events;

    public Group(){}

    public Group(Group copy){
        this.id = copy.id;
        this.name = copy.name;
        this.address = copy.address;
        this.cook_id = copy.cook_id;
        this.description = copy.description;
    }

    public Group(long id, String name, String address, long cook_id, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cook_id = cook_id;
        this.description = description;
    }

    public Group(String name, String address, long cook_id, String description) {
        this.name = name;
        this.address = address;
        this.cook_id = cook_id;
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

    public long getCook_id() {
        return cook_id;
    }

    public void setCook_id(long cook_id) {
        this.cook_id = cook_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
