package com.example.credits.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CDI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String refAnneecdi;
    private String creePar;
    private LocalDate dateDossier;
    private String swift;
    private String langueswift;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client", referencedColumnName = "idClient")
    private Client clientDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiaire_id", referencedColumnName = "id")
    private Beneficiaire beneficiaireDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_details_id", referencedColumnName = "id")
    private CreditDetails creditDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_details_id", referencedColumnName = "id")
    private AmountDetails amountDetails;

    @OneToMany(mappedBy = "cdi", cascade = CascadeType.ALL)
    private List<Document> documents;

    // Getters
    public Long getId() {
        return id;
    }

    public String getRefAnneecdi() {
        return refAnneecdi;
    }

    public String getCreePar() {
        return creePar;
    }

    public LocalDate getDateDossier() {
        return dateDossier;
    }

    public String getSwift() {
        return swift;
    }

    public String getLangueswift() {
        return langueswift;
    }

    public Client getClientDetails() {
        return clientDetails;
    }

    public Beneficiaire getBeneficiaireDetails() {
        return beneficiaireDetails;
    }

    public CreditDetails getCreditDetails() {
        return creditDetails;
    }

    public AmountDetails getAmountDetails() {
        return amountDetails;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRefAnneeCDI(String refAnneecdi) {
        this.refAnneecdi = refAnneecdi;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

    public void setDateDossier(LocalDate dateDossier) {
        this.dateDossier = dateDossier;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public void setLangueswift(String langueswift) {
        this.langueswift = langueswift;
    }

    public void setClientDetails(Client clientDetails) {
        this.clientDetails = clientDetails;
    }

    public void setBeneficiaireDetails(Beneficiaire beneficiaireDetails) {
        this.beneficiaireDetails = beneficiaireDetails;
    }

    public void setCreditDetails(CreditDetails creditDetails) {
        this.creditDetails = creditDetails;
    }

    public void setAmountDetails(AmountDetails amountDetails) {
        this.amountDetails = amountDetails;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}

