package com.example.virement.repository;

import com.example.virement.model.HistoriqueTransaction;
import com.example.virement.model.PieceJointe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PieceJointeRepository extends JpaRepository<PieceJointe, Long> {
    List<PieceJointe> findByTransactionId(Long transactionId);
}


