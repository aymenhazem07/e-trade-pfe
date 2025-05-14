package com.example.credits.repository;

import com.example.credits.model.CDI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CDIRepository extends JpaRepository<CDI, Long> {

    List<CDI> findByCreePar(String userId);

}
