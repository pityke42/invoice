package org.invoice.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "user")

public class User {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
