package com.codegym.validateuser.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size (min = 2,max = 30)
    private String name;

    @Min(18)
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
