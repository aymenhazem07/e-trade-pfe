package com.example.domiciliation.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DonneesFinancieres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conditionsPaiement;
    private String modeLivraison;
    private String modeFacturation;
    private String delaiReglement;
    private String devise;
    private BigDecimal montantDevisePNF;
    private BigDecimal montantDeviseFOB;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditionsPaiement() {
        return conditionsPaiement;
    }

    public void setConditionsPaiement(String conditionsPaiement) {
        this.conditionsPaiement = conditionsPaiement;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison(String modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public String getModeFacturation() {
        return modeFacturation;
    }

    public void setModeFacturation(String modeFacturation) {
        this.modeFacturation = modeFacturation;
    }

    public String getDelaiReglement() {
        return delaiReglement;
    }

    public void setDelaiReglement(String delaiReglement) {
        this.delaiReglement = delaiReglement;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public BigDecimal getMontantDevisePNF() {
        return montantDevisePNF;
    }

    public void setMontantDevisePNF(BigDecimal montantDevisePNF) {
        this.montantDevisePNF = montantDevisePNF;
    }

    public BigDecimal getMontantDeviseFOB() {
        return montantDeviseFOB;
    }

    public void setMontantDeviseFOB(BigDecimal montantDeviseFOB) {
        this.montantDeviseFOB = montantDeviseFOB;
    }
}
