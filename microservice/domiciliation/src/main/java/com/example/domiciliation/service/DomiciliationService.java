package com.example.domiciliation.service;

import com.example.domiciliation.dto.DomiciliationDTO;
import com.example.domiciliation.model.*;
import com.example.domiciliation.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DomiciliationService {

    private final DomiciliationRepository domiciliationRepository;
    private final ContratCommercialRepository contratCommercialRepository;
    private final DonneesFinancieresRepository donneesFinancieresRepository;
    private final FournisseurRepository fournisseurRepository;
    private final InformationsMarchandiseRepository informationsMarchandiseRepository;

    private final PaysRepository paysRepository;

    private final ModelMapper mapper;

    private static final String PATHDOC="C:\\Users\\DELL\\Desktop\\pfe projet (trade)\\Piece_joites_dom";



    private final PieceJointeRepository pieceJointeRepository;
    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public DomiciliationService(DomiciliationRepository domiciliationRepository,
                                PieceJointeRepository pieceJointeRepository,
                                HistoriqueRepository historiqueRepository,
                                ContratCommercialRepository ContratCommercialRepository,
                                DonneesFinancieresRepository DonneesFinancieresRepository,
                                FournisseurRepository FournisseurRepository,
                                InformationsMarchandiseRepository InformationsMarchandiseRepository,
                                PaysRepository PaysRepository, ModelMapper mapper)
     {
        this.domiciliationRepository = domiciliationRepository;
        this.pieceJointeRepository = pieceJointeRepository;
        this.historiqueRepository = historiqueRepository;
        this.contratCommercialRepository = ContratCommercialRepository;
        this.donneesFinancieresRepository = DonneesFinancieresRepository;
        this.fournisseurRepository= FournisseurRepository;
        this.informationsMarchandiseRepository = InformationsMarchandiseRepository;
        this.paysRepository = PaysRepository;
         this.mapper = mapper;
     }

    //@Transactional
    public Domiciliation saveDomiciliation(Domiciliation domiciliation) {
        Fournisseur fournisseur = fournisseurRepository.save(domiciliation.getFournisseur());
        ContratCommercial contratCommercial = contratCommercialRepository.save(domiciliation.getContratCommercial());
        DonneesFinancieres donneesFinancieres = donneesFinancieresRepository.save(domiciliation.getDonneesFinancieres());
        InformationsMarchandise informationsMarchandise = informationsMarchandiseRepository.save(domiciliation.getInformationsMarchandise());
        Pays pays = paysRepository.save(domiciliation.getPays());

        domiciliation.setFournisseur(fournisseur);
        domiciliation.setContratCommercial(contratCommercial);
        domiciliation.setDonneesFinancieres(donneesFinancieres);
        domiciliation.setInformationsMarchandise(informationsMarchandise);
        domiciliation.setPays(pays);
        domiciliation.getPiecesJointes().forEach( doc ->{
            PieceJointe piece = new PieceJointe();
            piece.setNomFichier(doc.getNomFichier());
            piece.setTypeContenu(doc.getTypeContenu());
            pieceJointeRepository.save(piece);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(PATHDOC);
                sb.append(File.separator);
                sb.append("demandes");
                sb.append(File.separator);
                Files.createDirectories(Paths.get(sb.toString()));
                sb.append(doc.getNomFichier());
                Files.write(Paths.get(sb.toString()), doc.getDonnees());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return domiciliationRepository.save(domiciliation);
    }

    @Transactional(readOnly = true)
    public List<DomiciliationDTO> findAllDomiciliations() {
        List<Domiciliation> domiciliationList=domiciliationRepository.findAll();
        return domiciliationList.stream().map(domiciliation -> mapper.map(domiciliation,DomiciliationDTO.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Domiciliation findDomiciliationById(Long id) {
        return domiciliationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Domiciliation not found with id: " + id));
    }

    @Transactional
    public Domiciliation updateDomiciliation(Long id, Domiciliation newDomiciliation) {
        return domiciliationRepository.findById(id)
                .map(domiciliation -> {
                    domiciliation.setTitreNature(newDomiciliation.getTitreNature());
                    domiciliation.setCreePar(newDomiciliation.getCreePar());
                    domiciliation.setDateDomiciliation(newDomiciliation.getDateDomiciliation());
                    domiciliation.setDateExpiration(newDomiciliation.getDateExpiration());
                    return domiciliationRepository.save(domiciliation);
                })
                .orElseThrow(() -> new RuntimeException("Domiciliation not found with id: " + id));
    }

    @Transactional
    public void deleteDomiciliation(Long id) {
        Domiciliation domiciliation = domiciliationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Domiciliation not found with id: " + id));
        domiciliationRepository.delete(domiciliation);
    }

    @Transactional
    public PieceJointe saveAttachment(PieceJointe attachment) {
        return pieceJointeRepository.save(attachment);
    }

    @Transactional
    public void deleteAttachment(Long id) {
        PieceJointe attachment = pieceJointeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attachment not found with id: " + id));
        pieceJointeRepository.delete(attachment);
    }

    @Transactional
    public Historique saveHistory(Historique history) {
        return historiqueRepository.save(history);
    }

    @Transactional
    public void deleteHistory(Long id) {
        Historique history = historiqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History record not found with id: " + id));
        historiqueRepository.delete(history);
    }
}

