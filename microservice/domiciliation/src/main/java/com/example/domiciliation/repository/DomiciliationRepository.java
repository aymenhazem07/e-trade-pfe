package com.example.domiciliation.repository;


import com.example.domiciliation.model.Domiciliation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomiciliationRepository extends JpaRepository<Domiciliation, Long> {

    List<Domiciliation> findByCreePar(String userId);
}
