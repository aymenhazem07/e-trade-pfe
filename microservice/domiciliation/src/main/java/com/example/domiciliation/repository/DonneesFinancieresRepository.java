package com.example.domiciliation.repository;

import com.example.domiciliation.model.DonneesFinancieres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonneesFinancieresRepository extends JpaRepository<DonneesFinancieres, Long> {
}
