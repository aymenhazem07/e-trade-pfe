package com.example.virement.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private Date dateEmission;
    private String typeVirement;
    private String typeDevise;
    private String typeFrais;
    private String typeAchat;
    private String numeroFacture;
    private Date dateFacture;
    private String motif;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Fournisseur fournisseur;

    private  Integer compteNumber;

    private Integer fournisseurNumber;

    // Getters
    public Long getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public String getTypeVirement() {
        return typeVirement;
    }

    public String getTypeDevise() {
        return typeDevise;
    }

    public String getTypeFrais() {
        return typeFrais;
    }

    public String getTypeAchat() {
        return typeAchat;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public String getMotif() {
        return motif;
    }

    public Client getClient() {
        return client;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public void setTypeVirement(String typeVirement) {
        this.typeVirement = typeVirement;
    }

    public void setTypeDevise(String typeDevise) {
        this.typeDevise = typeDevise;
    }

    public void setTypeFrais(String typeFrais) {
        this.typeFrais = typeFrais;
    }

    public void setTypeAchat(String typeAchat) {
        this.typeAchat = typeAchat;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Integer getCompteNumber() {
        return compteNumber;
    }

    public Integer getFournisseurNumber() {
        return fournisseurNumber;
    }

    public void setCompteNumber(Integer compteNumber) {
        this.compteNumber = compteNumber;
    }

    public void setFournisseurNumber(Integer fournisseurNumber) {
        this.fournisseurNumber = fournisseurNumber;
    }
}

