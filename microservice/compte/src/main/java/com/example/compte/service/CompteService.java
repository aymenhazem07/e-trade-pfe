package com.example.compte.service;

import com.example.compte.model.Compte;
import com.example.compte.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Compte getCompteById(Long id) {
        Optional<Compte> compte = compteRepository.findById(id);
        return compte.orElse(null);
    }

    public Compte updateCompte(Compte compte, Long id) {
        if (compteRepository.existsById(id)) {
            compte.setId(id);
            return compteRepository.save(compte);
        } else {
            return null;
        }
    }

    public boolean deleteCompte(Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
