package org.invoice.repository.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "invoice_product_x")

public class XInvoiceProduct {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(
            name = "invoice_id",
            referencedColumnName = "id"
    )
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private Product product;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}