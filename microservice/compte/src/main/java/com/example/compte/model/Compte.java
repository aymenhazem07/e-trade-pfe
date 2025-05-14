package com.example.compte.model;


import jakarta.persistence.*;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeClient;
    private String nomClient;
    private String emailClient;
    private String identite;
    private String identiteFiscale;
    private String adresse;
    private String compteReglement;
    private String compteCommission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getIdentiteFiscale() {
        return identiteFiscale;
    }

    public void setIdentiteFiscale(String identiteFiscale) {
        this.identiteFiscale = identiteFiscale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCompteReglement() {
        return compteReglement;
    }

    public void setCompteReglement(String compteReglement) {
        this.compteReglement = compteReglement;
    }

    public String getCompteCommission() {
        return compteCommission;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }
}
