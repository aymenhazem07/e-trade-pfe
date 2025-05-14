package com.example.virement.repository;

import com.example.virement.model.HistoriqueTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HistoriqueTransactionRepository extends JpaRepository<HistoriqueTransaction, Long> {
    List<HistoriqueTransaction> findAllByTransactionId(Long transactionId);
}

