package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class District {
    @Id
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Street> streetSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Street> getStreetSet() {
        return streetSet;
    }

    public void setStreetSet(Set<Street> streetSet) {
        this.streetSet = streetSet;
    }

    public void setStreet (Street street) {
        if (this.streetSet == null) {
            this.streetSet = new HashSet<>();
        }
        this.streetSet.add(street);
    }
}
