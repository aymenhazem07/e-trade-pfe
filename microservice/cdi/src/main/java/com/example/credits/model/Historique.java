package com.example.credits.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private LocalDateTime date;
    private String utilisateur;

    // Getters
    public Long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}

