package com.example.domiciliation.model;

import jakarta.persistence.*;

@Entity

public class PieceJointe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFichier;
    private String typeContenu;
    @Lob
    private byte[] donnees;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getTypeContenu() {
        return typeContenu;
    }

    public void setTypeContenu(String typeContenu) {
        this.typeContenu = typeContenu;
    }

    public byte[] getDonnees() {
        return donnees;
    }

    public void setDonnees(byte[] donnees) {
        this.donnees = donnees;
    }
}
