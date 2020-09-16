package com.example.entity.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private  String name;



    @Min(50)
    @Max(value = 200 ,message = "This field min 50 max 200 !")
    private double area;


    @Min(1)
    @Max(value = 20 ,message = "This field min 1 max 20")
    private int numberOfFloors;


    @Min(1)
    @Max(value = 20 ,message = "Max 20")
    private int maxPeople;


    @Min(0)
    private double feeRent;


    @ManyToOne
    @JoinColumn (name = "type_rent_id")
    private TypeRent typeRent;


    @ManyToOne
    @JoinColumn (name = "type_service_id")
    private TypeService typeService;

    @NotEmpty
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getFeeRent() {
        return feeRent;
    }

    public void setFeeRent(double feeRent) {
        this.feeRent = feeRent;
    }

    public TypeRent getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(TypeRent typeRent) {
        this.typeRent = typeRent;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
