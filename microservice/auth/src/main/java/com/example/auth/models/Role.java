package com.example.auth.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }
    // Getter pour id
    public Integer getId() {
        return id;
    }

    // Setter pour id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter pour name
    public ERole getName() {
        return name;
    }

    // Setter pour name
    public void setName(ERole name) {
        this.name = name;
    }
}
