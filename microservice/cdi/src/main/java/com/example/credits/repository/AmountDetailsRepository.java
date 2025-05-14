package com.example.credits.repository;

import com.example.credits.model.AmountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountDetailsRepository extends JpaRepository<AmountDetails, Long> {
}
