package com.example.entity.model;

import com.example.buildAnnotation.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "customer_type_id")
    private CustomerType customerType;
    @NotEmpty
//    @Pattern(regexp = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$",message = "Name not valid ! ")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$",message = "datetime not valid !")
    private String birthday;
    @NotEmpty
    @Pattern(regexp = "\\d{8,12}")
    private String CMND;
    @NotEmpty
    @Pattern(regexp = "[0]{1}[^0]\\d{8,9}",message = "Phone number not valid !")
    private String phone;
    @NotEmpty
    @Pattern(regexp = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)",message = "This email not valid !")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$",message = "This add not valid !")
    private String address;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}