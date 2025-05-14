package com.example.compte.controller;

import com.example.compte.model.Compte;
import com.example.compte.model.CompteDTO;
import com.example.compte.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping
    public ResponseEntity<Compte> addCompte(@RequestBody Compte compte) {
        try {
            Compte newCompte = compteService.saveCompte(compte);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Compte>> getAllComptes() {
        try {
            List<Compte> comptes = compteService.getAllComptes();
            return ResponseEntity.ok(comptes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
        Compte compte = compteService.getCompteById(id);
        return compte != null ? ResponseEntity.ok(compte) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> updateCompte(@RequestBody Compte compte, @PathVariable Long id) {
        try {
            Compte updatedCompte = compteService.updateCompte(compte, id);
            return updatedCompte != null ? ResponseEntity.ok(updatedCompte) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompte(@PathVariable Long id) {
        try {
            boolean deleted = compteService.deleteCompte(id);
            return deleted ? ResponseEntity.ok("Le compte a été supprimé avec succès") : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du compte");
        }
    }
}
