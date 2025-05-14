package com.example.domiciliation.model;

import jakarta.persistence.*;

@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paysAchat;

    private String paysProvenance;

    private String destinationFinale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaysAchat() {
        return paysAchat;
    }

    public void setPaysAchat(String paysAchat) {
        this.paysAchat = paysAchat;
    }

    public String getPaysProvenance() {
        return paysProvenance;
    }

    public void setPaysProvenance(String paysProvenance) {
        this.paysProvenance = paysProvenance;
    }

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }
}
