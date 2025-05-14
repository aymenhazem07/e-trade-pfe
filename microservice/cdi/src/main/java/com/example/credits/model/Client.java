package com.example.credits.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String compteReglement;
    private String codeClient;
    private String identiteFiscale;
    private String email;
    private String compteCommission;
    private String nomClient;
    private String identite;
    private String adresse;

    // Getters
    public Long getIdClient() {
        return idClient;
    }

    public String getCompteReglement() {
        return compteReglement;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getIdentiteFiscale() {
        return identiteFiscale;
    }

    public String getEmail() {
        return email;
    }

    public String getCompteCommission() {
        return compteCommission;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getIdentite() {
        return identite;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setCompteReglement(String compteReglement) {
        this.compteReglement = compteReglement;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setIdentiteFiscale(String identiteFiscale) {
        this.identiteFiscale = identiteFiscale;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

