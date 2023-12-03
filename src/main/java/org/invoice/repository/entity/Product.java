package org.invoice.repository.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Integer buyPrice;
    private Integer nettoPrice;
    private Integer salePrice;
    private Integer quantity;
    private String weight;

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

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(Integer nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
