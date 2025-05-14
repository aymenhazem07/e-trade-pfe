package com.example.virement.repository;

import com.example.virement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    List<Transaction> findByCompteNumber(Long id);


}
