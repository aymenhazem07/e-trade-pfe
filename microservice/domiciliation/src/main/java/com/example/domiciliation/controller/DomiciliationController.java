package com.example.domiciliation.controller;

import com.example.domiciliation.dto.DomiciliationDTO;
import com.example.domiciliation.model.Domiciliation;
import com.example.domiciliation.model.Fournisseur;
import com.example.domiciliation.model.Historique;
import com.example.domiciliation.model.PieceJointe;
import com.example.domiciliation.repository.DomiciliationRepository;
import com.example.domiciliation.repository.FournisseurRepository;
import com.example.domiciliation.service.DomiciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/domiciliations")
public class DomiciliationController {

    private final DomiciliationService domiciliationService;

    @Autowired
    private DomiciliationRepository domRepo;

    @Autowired
    private FournisseurRepository fournisseurRepo;

    @Autowired
    public DomiciliationController(DomiciliationService domiciliationService) {
        this.domiciliationService = domiciliationService;
    }

    @PostMapping
    public ResponseEntity<Domiciliation> createDomiciliation(@RequestBody Domiciliation domiciliation) {
        System.out.println();
        Domiciliation createdDomiciliation = domiciliationService.saveDomiciliation(domiciliation);
        return new ResponseEntity<>(createdDomiciliation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DomiciliationDTO>> getAllDomiciliations() {
        List<DomiciliationDTO> domiciliations = domiciliationService.findAllDomiciliations();
        return new ResponseEntity<>(domiciliations, HttpStatus.OK);
    }

    @GetMapping("get-dom/{userId}")
    public ResponseEntity<List<Domiciliation>> getDomiciliationByUserId(@PathVariable("userId") String userId) {
        List<Domiciliation> domiciliations = domRepo.findByCreePar(userId);

        return new ResponseEntity<>(domiciliations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domiciliation> getDomiciliationById(@PathVariable("id") Long id) {
        Domiciliation domiciliation = domiciliationService.findDomiciliationById(id);
        return new ResponseEntity<>(domiciliation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Domiciliation> updateDomiciliation(@PathVariable("id") Long id, @RequestBody Domiciliation domiciliation) {
        Domiciliation updatedDomiciliation = domiciliationService.updateDomiciliation(id, domiciliation);
        return new ResponseEntity<>(updatedDomiciliation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomiciliation(@PathVariable("id") Long id) {
        domiciliationService.deleteDomiciliation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/attachments")
    public ResponseEntity<PieceJointe> saveAttachment(@RequestBody PieceJointe attachment) {
        PieceJointe savedAttachment = domiciliationService.saveAttachment(attachment);
        return new ResponseEntity<>(savedAttachment, HttpStatus.CREATED);
    }

    @DeleteMapping("/attachments/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable("id") Long id) {
        domiciliationService.deleteAttachment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/history")
    public ResponseEntity<Historique> saveHistory(@RequestBody Historique history) {
        Historique savedHistory = domiciliationService.saveHistory(history);
        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
    }

    @DeleteMapping("/history/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable("id") Long id) {
        domiciliationService.deleteHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("find-all-fournisseurs")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        try {
            List<Fournisseur> fournisseurs = fournisseurRepo.findAll();
            return ResponseEntity.ok(fournisseurs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
