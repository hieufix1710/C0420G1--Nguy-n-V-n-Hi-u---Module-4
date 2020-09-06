package com.codegym.furamaspringboot.model;

import javax.persistence.*;

@Entity
@Table (name = "detail_contract")
public class DetailContract {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (columnDefinition = "contract_id")
    private Contract contract;

    private String quantity;

    @ManyToOne
    @JoinColumn ( name = "attach_service_id")
    private AttachService attachService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
