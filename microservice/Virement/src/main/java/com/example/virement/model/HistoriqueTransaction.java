package com.example.virement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistoriqueTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateModification;
    private String detailModification;

    @ManyToOne
    private Transaction transaction;

    // Getters
    public Long getId() {
        return id;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public String getDetailModification() {
        return detailModification;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public void setDetailModification(String detailModification) {
        this.detailModification = detailModification;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
