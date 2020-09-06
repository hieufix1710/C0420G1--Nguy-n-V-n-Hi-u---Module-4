package com.codegym.furamaspringboot.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table (name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private  String name;
    @Min(1)
    private  double cost;

    @Min(1)
    @NotBlank
    private  int unit;
    private  String status;

    @OneToMany
    private List<DetailContract> detailContract;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailContract> getDetailContract() {
        return detailContract;
    }

    public void setDetailContract(List<DetailContract> detailContract) {
        this.detailContract = detailContract;
    }
}
