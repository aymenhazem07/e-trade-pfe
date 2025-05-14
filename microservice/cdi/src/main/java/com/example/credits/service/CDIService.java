package com.example.credits.service;


import com.example.credits.model.Attachment;
import com.example.credits.model.CDI;
import com.example.credits.model.Historique;
import com.example.credits.repository.AttachmentRepository;
import com.example.credits.repository.CDIRepository;
import com.example.credits.repository.HistoriqueRepository;
import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CDIService {
    private static final Logger logger = LoggerFactory.getLogger(CDIService.class);

    private final CDIRepository cdiRepository;
    private final AttachmentRepository attachmentRepository;
    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public CDIService(CDIRepository cdiRepository, AttachmentRepository attachmentRepository, HistoriqueRepository historiqueRepository) {
        this.cdiRepository = cdiRepository;
        this.attachmentRepository = attachmentRepository;
        this.historiqueRepository = historiqueRepository;
    }

    @Transactional
    public CDI createCDI(CDI cdi) {
        logger.info("Creating a new CDI entry: {}", cdi);
        return cdiRepository.save(cdi);
    }

    public Optional<CDI> getCDIById(Long id) {
        logger.debug("Retrieving CDI with id: {}", id);
        return cdiRepository.findById(id);
    }

    public List<CDI> getAllCDIs() {
        logger.debug("Retrieving all CDI entries");
        return cdiRepository.findAll();
    }

    @Transactional
    public CDI updateCDI(CDI cdi) {
        logger.info("Updating CDI: {}", cdi);
        return cdiRepository.save(cdi);
    }

    @Transactional
    public void deleteCDI(Long id) {
        try {
            logger.info("Deleting CDI with id: {}", id);
            cdiRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error while deleting CDI. ID does not exist: {}", id, e);
            throw new RuntimeException("CDI not found with ID: " + id, e);
        }
    }

    @Transactional
    public Attachment addAttachmentToCDI(Long cdiId, Attachment attachment) {
        logger.info("Adding attachment to CDI with ID: {}", cdiId);
        CDI cdi = cdiRepository.findById(cdiId).orElseThrow(() -> new IllegalArgumentException("CDI not found with ID: " + cdiId));
        attachment = attachmentRepository.save(attachment);
        // Linking logic if necessary
        return attachment;
    }

    @Transactional
    public Historique logAction(Long cdiId, String action, String utilisateur) {
        logger.info("Logging action for CDI with ID: {}. Action: {}", cdiId, action);
        CDI cdi = cdiRepository.findById(cdiId).orElseThrow(() -> new IllegalArgumentException("CDI not found with ID: " + cdiId));
        Historique historique = new Historique();
        historique.setAction(action);
        historique.setDate(LocalDateTime.now());
        historique.setUtilisateur(utilisateur);
        historique = historiqueRepository.save(historique);
        return historique;
    }
}

