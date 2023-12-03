package org.invoice.repository.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "company")

public class Company {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String taxNumber;
    private String shortName;
    private String governmentCompanyNumber;
    @OneToOne
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id"
    )
    private Address address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getGovernmentCompanyNumber() {
        return governmentCompanyNumber;
    }

    public void setGovernmentCompanyNumber(String governmentCompanyNumber) {
        this.governmentCompanyNumber = governmentCompanyNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



}

