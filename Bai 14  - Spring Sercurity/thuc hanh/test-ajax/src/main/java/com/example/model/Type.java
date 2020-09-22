package com.example.model;

import javax.persistence.*;

@Entity
@Table (name = "type")
public class Type {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
