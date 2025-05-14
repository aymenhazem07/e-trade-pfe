package com.example.credits.model;

import jakarta.persistence.*;

@Entity
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomBeneficiaire;
    private String pays;
    private String email;
    private String telephone;
    private String nomContact;
    private String nCompteBeneficiaire;
    private String banque;
    private String adresse;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public String getPays() {
        return pays;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getNCompteBeneficiaire() {
        return nCompteBeneficiaire;
    }

    public String getBanque() {
        return banque;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public void setNCompteBeneficiaire(String nCompteBeneficiaire) {
        this.nCompteBeneficiaire = nCompteBeneficiaire;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

