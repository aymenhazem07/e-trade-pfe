package com.example.credits.repository;

import com.example.credits.model.CreditDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDetailsRepository extends JpaRepository<CreditDetails, Long> {
}
