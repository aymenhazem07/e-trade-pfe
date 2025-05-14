package com.example.domiciliation.dto;

import java.time.LocalDate;
import java.util.List;

public class DomiciliationDTO {
    private Long id;
    private String titreNature;
    private String creePar;
    private LocalDate dateDomiciliation;
    private LocalDate dateExpiration;

    public DomiciliationDTO() {
    }

    public DomiciliationDTO(Long id, String titreNature, String creePar, LocalDate dateDomiciliation, LocalDate dateExpiration) {
        this.id = id;
        this.titreNature = titreNature;
        this.creePar = creePar;
        this.dateDomiciliation = dateDomiciliation;
        this.dateExpiration = dateExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreNature() {
        return titreNature;
    }

    public void setTitreNature(String titreNature) {
        this.titreNature = titreNature;
    }

    public String getCreePar() {
        return creePar;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

    public LocalDate getDateDomiciliation() {
        return dateDomiciliation;
    }

    public void setDateDomiciliation(LocalDate dateDomiciliation) {
        this.dateDomiciliation = dateDomiciliation;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
