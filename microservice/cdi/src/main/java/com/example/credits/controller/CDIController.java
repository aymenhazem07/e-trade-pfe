package com.example.credits.controller;

import com.example.credits.model.Attachment;
import com.example.credits.model.CDI;
import com.example.credits.model.Historique;
import com.example.credits.repository.CDIRepository;
import com.example.credits.service.CDIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cdi")
public class CDIController {
    private final CDIService cdiService;

    @Autowired
    private CDIRepository cdiRepo;

    @Autowired
    public CDIController(CDIService cdiService) {
        this.cdiService = cdiService;
    }

    // Create a new CDI
    @PostMapping
    public ResponseEntity<CDI> createCDI(@RequestBody CDI cdi) {
        CDI savedCDI = cdiService.createCDI(cdi);
        return new ResponseEntity<>(savedCDI, HttpStatus.CREATED);
    }

    // Retrieve a single CDI by ID
    @GetMapping("/{id}")
    public ResponseEntity<CDI> getCDIById(@PathVariable Long id) {
        return cdiService.getCDIById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all CDIs
    @GetMapping
    public List<CDI> getAllCDIs() {
        return cdiService.getAllCDIs();
    }

    @GetMapping("get-cdi/{userId}")
    public ResponseEntity<List<CDI>> getCdiByUserId(@PathVariable("userId") String userId) {
        List<CDI> cdis = cdiRepo.findByCreePar(userId);

        return new ResponseEntity<>(cdis, HttpStatus.OK);
    }

    // Update a CDI
    @PutMapping("/{id}")
    public ResponseEntity<CDI> updateCDI(@PathVariable Long id, @RequestBody CDI cdi) {
        if (!cdiService.getCDIById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cdi.setId(id);
        CDI updatedCDI = cdiService.updateCDI(cdi);
        return ResponseEntity.ok(updatedCDI);
    }

    // Delete a CDI
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCDI(@PathVariable Long id) {
        if (!cdiService.getCDIById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cdiService.deleteCDI(id);
        return ResponseEntity.noContent().build();
    }

    // Additional endpoint to attach a document to a CDI
    @PostMapping("/{cdiId}/attachments")
    public ResponseEntity<Attachment> addAttachmentToCDI(@PathVariable Long cdiId, @RequestBody Attachment attachment) {
        try {
            Attachment savedAttachment = cdiService.addAttachmentToCDI(cdiId, attachment);
            return new ResponseEntity<>(savedAttachment, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint to log actions related to a CDI
    @PostMapping("/{cdiId}/historique")
    public ResponseEntity<Historique> logAction(@PathVariable Long cdiId, @RequestBody Historique historique) {
        try {
            Historique savedHistorique = cdiService.logAction(cdiId, historique.getAction(), historique.getUtilisateur());
            return new ResponseEntity<>(savedHistorique, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
