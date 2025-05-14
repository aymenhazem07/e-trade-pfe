package com.example.virement.model;

import jakarta.persistence.*;

@Entity
public class PieceJointe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFichier;
    private String typeFichier; // example: "pdf", "image", etc.
    private byte[] contenu;

    @ManyToOne
    private Transaction transaction;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public String getTypeFichier() {
        return typeFichier;
    }

    public byte[] getContenu() {
        return contenu;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public void setTypeFichier(String typeFichier) {
        this.typeFichier = typeFichier;
    }

    public void setContenu(byte[] contenu) {
        this.contenu = contenu;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
