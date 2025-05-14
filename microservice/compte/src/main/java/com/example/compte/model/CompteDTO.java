package com.example.compte.model;


public class CompteDTO {

    private Long id;
    private String codeClient;
    private String nomClient;
    private String emailClient;
    private String identite;
    private String identiteFiscale;
    private String adresse;
    private String compteReglement;
    private String compteCommission;

    public CompteDTO(Long id, String codeClient, String nomClient, String emailClient, String identite, String identiteFiscale, String adresse, String compteReglement, String compteCommission) {
        this.id = id;
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.emailClient = emailClient;
        this.identite = identite;
        this.identiteFiscale = identiteFiscale;
        this.adresse = adresse;
        this.compteReglement = compteReglement;
        this.compteCommission = compteCommission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
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

    public void setCompteReglement(String compteReglement) {
        this.compteReglement = compteReglement;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getEmailClient() {
        return emailClient;
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

    public String getCompteReglement() {
        return compteReglement;
    }

    public String getCompteCommission() {
        return compteCommission;
    }
}
