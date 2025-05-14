package com.example.credits.model;

import jakarta.persistence.*;

@Entity
public class CreditDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formeCredit;
    private String fraisTunisie;
    private String standBy;
    private String transbandement;
    private String expeditionPartielle;
    private String transferable;
    private String assuranceDonneurOrdre;
    private String descriptionMarchandise;

    // Getters
    public Long getId() {
        return id;
    }

    public String getFormeCredit() {
        return formeCredit;
    }

    public String getFraisTunisie() {
        return fraisTunisie;
    }

    public String getStandBy() {
        return standBy;
    }

    public String getTransbandement() {
        return transbandement;
    }

    public String getExpeditionPartielle() {
        return expeditionPartielle;
    }

    public String getTransferable() {
        return transferable;
    }

    public String getAssuranceDonneurOrdre() {
        return assuranceDonneurOrdre;
    }

    public String getDescriptionMarchandise() {
        return descriptionMarchandise;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFormeCredit(String formeCredit) {
        this.formeCredit = formeCredit;
    }

    public void setFraisTunisie(String fraisTunisie) {
        this.fraisTunisie = fraisTunisie;
    }

    public void setStandBy(String standBy) {
        this.standBy = standBy;
    }

    public void setTransbandement(String transbandement) {
        this.transbandement = transbandement;
    }

    public void setExpeditionPartielle(String expeditionPartielle) {
        this.expeditionPartielle = expeditionPartielle;
    }

    public void setTransferable(String transferable) {
        this.transferable = transferable;
    }

    public void setAssuranceDonneurOrdre(String assuranceDonneurOrdre) {
        this.assuranceDonneurOrdre = assuranceDonneurOrdre;
    }

    public void setDescriptionMarchandise(String descriptionMarchandise) {
        this.descriptionMarchandise = descriptionMarchandise;
    }
}

