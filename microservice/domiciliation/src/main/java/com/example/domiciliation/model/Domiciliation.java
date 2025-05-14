package com.example.domiciliation.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Domiciliation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titreNature;
    private String creePar;
    private LocalDate dateDomiciliation;
    private LocalDate dateExpiration;

   @ManyToOne
   @JoinColumn(name="fournisseur_id", nullable=false)
    private Fournisseur fournisseur;

    @OneToOne
    private Pays pays;

    @OneToOne
    private ContratCommercial contratCommercial;

    @OneToOne
    private DonneesFinancieres donneesFinancieres;
    @OneToOne
    private InformationsMarchandise informationsMarchandise;

    @Transient
    private List<PieceJointe> piecesJointes;

   @OneToMany
    private List<Historique> historique;

    // Getters and Setters
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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Pays getPays() {
        return pays;
    }



    public ContratCommercial getContratCommercial() {
        return contratCommercial;
    }

    public void setContratCommercial(ContratCommercial contratCommercial) {
        this.contratCommercial = contratCommercial;
    }

    public DonneesFinancieres getDonneesFinancieres() {
        return donneesFinancieres;
    }

    public void setDonneesFinancieres(DonneesFinancieres donneesFinancieres) {
        this.donneesFinancieres = donneesFinancieres;
    }

    public InformationsMarchandise getInformationsMarchandise() {
        return informationsMarchandise;
    }

    public void setInformationsMarchandise(InformationsMarchandise informationsMarchandise) {
        this.informationsMarchandise = informationsMarchandise;
    }

    public List<PieceJointe> getPiecesJointes() {
        return piecesJointes;
    }

    public void setPiecesJointes(List<PieceJointe> piecesJointes) {
        this.piecesJointes = piecesJointes;
    }

    public List<Historique> getHistorique() {
        return historique;
    }

    public void setHistorique(List<Historique> historique) {
        this.historique = historique;
    }
}

