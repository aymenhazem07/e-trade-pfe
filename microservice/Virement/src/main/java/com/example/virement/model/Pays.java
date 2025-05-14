package com.example.virement.model;


import jakarta.persistence.*;

@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

