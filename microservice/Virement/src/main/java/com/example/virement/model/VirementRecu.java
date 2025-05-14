package com.example.virement.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class VirementRecu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String informationClient;

    @Column(nullable = false)
    private String compteCommission;

    @Column(nullable = false)
    private String compteReglement;

    @Temporal(TemporalType.DATE)
    private Date dateReception;

    @Enumerated(EnumType.STRING)
    private Devise devise;

    @Column(nullable = false)
    private BigDecimal montantVirement;

    // Constructeurs
    public VirementRecu() {
        // Constructeur par défaut
    }

    public VirementRecu(String informationClient, String compteCommission, String compteReglement,
                        Date dateReception, Devise devise, BigDecimal montantVirement) {
        this.informationClient = informationClient;
        this.compteCommission = compteCommission;
        this.compteReglement = compteReglement;
        this.dateReception = dateReception;
        this.devise = devise;
        this.montantVirement = montantVirement;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInformationClient() {
        return informationClient;
    }

    public void setInformationClient(String informationClient) {
        this.informationClient = informationClient;
    }

    public String getCompteCommission() {
        return compteCommission;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }

    public String getCompteReglement() {
        return compteReglement;
    }

    public void setCompteReglement(String compteReglement) {
        this.compteReglement = compteReglement;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public BigDecimal getMontantVirement() {
        return montantVirement;
    }

    public void setMontantVirement(BigDecimal montantVirement) {
        this.montantVirement = montantVirement;
    }

    // Enumération pour simplifier les choix
    public enum Devise {
        EUR, USD, GBP
    }
}
