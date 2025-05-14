package com.example.virement.model;


import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeClient;
    private String compteReglement;
    private String compteCommission;
    private String nom;
    private String email;
    private String identite;
    private String identiteFiscale;
    private String adresse;

    // Getters
    public Long getId() {
        return id;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getCompteReglement() {
        return compteReglement;
    }

    public String getCompteCommission() {
        return compteCommission;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentite() {
        return identite;
    }

    public String getIdentiteFiscale() {
        return identiteFiscale;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setCompteReglement(String compteReglement) {
        this.compteReglement = compteReglement;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public void setIdentiteFiscale(String identiteFiscale) {
        this.identiteFiscale = identiteFiscale;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

