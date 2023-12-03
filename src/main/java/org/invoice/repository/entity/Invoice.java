package org.invoice.repository.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invoice")

public class Invoice {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id")
    private User user;
    @OneToMany(
            mappedBy = "invoice"
    )
    private List<XInvoiceProduct> xInvoiceProducts;

    @OneToOne
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "id")
    private Company company;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<XInvoiceProduct> getxInvoiceProducts() {
        return xInvoiceProducts;
    }

    public void setxInvoiceProducts(List<XInvoiceProduct> xInvoiceProducts) {
        this.xInvoiceProducts = xInvoiceProducts;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
