package com.example.domiciliation.repository;

import com.example.domiciliation.model.ContratCommercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratCommercialRepository extends JpaRepository<ContratCommercial, Long> {
}
