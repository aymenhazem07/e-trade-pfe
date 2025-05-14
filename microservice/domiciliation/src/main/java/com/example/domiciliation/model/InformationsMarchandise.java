package com.example.domiciliation.model;

import jakarta.persistence.*;


@Entity
public class InformationsMarchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinationFinale;
    private String numeroContrat;
    private String modeLivraison;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison(String modeLivraison) {
        this.modeLivraison = modeLivraison;
    }
}
