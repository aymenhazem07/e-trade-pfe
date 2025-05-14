package com.example.credits.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
public class AmountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal montant;
    private BigDecimal montantAVue;
    private BigDecimal montantATerme;
    private BigDecimal tauxAVue;
    private BigDecimal tauxATerme;
    private BigDecimal montantMaximum;
    private BigDecimal tolerancePositive;
    private BigDecimal toleranceNegative;

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public BigDecimal getMontantAVue() {
        return montantAVue;
    }

    public BigDecimal getMontantATerme() {
        return montantATerme;
    }

    public BigDecimal getTauxAVue() {
        return tauxAVue;
    }

    public BigDecimal getTauxATerme() {
        return tauxATerme;
    }

    public BigDecimal getMontantMaximum() {
        return montantMaximum;
    }

    public BigDecimal getTolerancePositive() {
        return tolerancePositive;
    }

    public BigDecimal getToleranceNegative() {
        return toleranceNegative;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setMontantAVue(BigDecimal montantAVue) {
        this.montantAVue = montantAVue;
    }

    public void setMontantATerme(BigDecimal montantATerme) {
        this.montantATerme = montantATerme;
    }

    public void setTauxAVue(BigDecimal tauxAVue) {
        this.tauxAVue = tauxAVue;
    }

    public void setTauxATerme(BigDecimal tauxATerme) {
        this.tauxATerme = tauxATerme;
    }

    public void setMontantMaximum(BigDecimal montantMaximum) {
        this.montantMaximum = montantMaximum;
    }

    public void setTolerancePositive(BigDecimal tolerancePositive) {
        this.tolerancePositive = tolerancePositive;
    }

    public void setToleranceNegative(BigDecimal toleranceNegative) {
        this.toleranceNegative = toleranceNegative;
    }
}

