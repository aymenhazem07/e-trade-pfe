package com.example.credits.model;


import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;
    private Integer nombreOriginaux;
    private Integer nombreCopies;
    private Integer nombrePhotocopies;
    private String observation;
    private String numeroDHL;

    @ManyToOne
    @JoinColumn(name = "cdi_id")
    private CDI cdi;

    // Getters
    public Long getId() {
        return id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public Integer getNombreOriginaux() {
        return nombreOriginaux;
    }

    public Integer getNombreCopies() {
        return nombreCopies;
    }

    public Integer getNombrePhotocopies() {
        return nombrePhotocopies;
    }

    public String getObservation() {
        return observation;
    }

    public String getNumeroDHL() {
        return numeroDHL;
    }

    public CDI getCdi() {
        return cdi;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public void setNombreOriginaux(Integer nombreOriginaux) {
        this.nombreOriginaux = nombreOriginaux;
    }

    public void setNombreCopies(Integer nombreCopies) {
        this.nombreCopies = nombreCopies;
    }

    public void setNombrePhotocopies(Integer nombrePhotocopies) {
        this.nombrePhotocopies = nombrePhotocopies;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setNumeroDHL(String numeroDHL) {
        this.numeroDHL = numeroDHL;
    }

    public void setCdi(CDI cdi) {
        this.cdi = cdi;
    }
}

