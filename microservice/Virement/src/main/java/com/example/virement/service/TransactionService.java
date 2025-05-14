package com.example.virement.service;

import com.example.virement.model.HistoriqueTransaction;
import com.example.virement.model.PieceJointe;
import com.example.virement.model.Transaction;
import com.example.virement.repository.HistoriqueTransactionRepository;
import com.example.virement.repository.PieceJointeRepository;
import com.example.virement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private PieceJointeRepository pieceJointeRepository;
    @Autowired
    private HistoriqueTransactionRepository historiqueTransactionRepository;

    // Ajouter une transaction
    public Transaction ajouterTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Obtenir une transaction par ID
    public Transaction obtenirTransaction(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction non trouvée"));
    }

    // Mettre à jour une transaction
    public Transaction mettreAJourTransaction(Transaction transaction) {
        if (transaction.getId() == null || !transactionRepository.existsById(transaction.getId())) {
            throw new RuntimeException("Transaction non trouvée pour mise à jour");
        }
        return transactionRepository.save(transaction);
    }

    // Supprimer une transaction
    public void supprimerTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction non trouvée pour suppression");
        }
        transactionRepository.deleteById(id);
    }

    // Ajouter une pièce jointe à une transaction
    public PieceJointe ajouterPieceJointe(Long transactionId, PieceJointe pieceJointe) {
        Transaction transaction = obtenirTransaction(transactionId); // Utilisation de la méthode obtenirTransaction
        pieceJointe.setTransaction(transaction);
        return pieceJointeRepository.save(pieceJointe);
    }

    // Consulter l'historique d'une transaction
    public List<HistoriqueTransaction> consulterHistorique(Long transactionId) {
        return historiqueTransactionRepository.findAllByTransactionId(transactionId);
    }

    // Ajouter un élément à l'historique d'une transaction
    public HistoriqueTransaction ajouterHistorique(HistoriqueTransaction historique) {
        return historiqueTransactionRepository.save(historique);
    }

    // Méthodes CRUD pour les pièces jointes et l'historique (exemple pour pièces jointes)
    public List<PieceJointe> obtenirPiecesJointesParTransaction(Long transactionId) {
        return pieceJointeRepository.findByTransactionId(transactionId);
    }

    public PieceJointe obtenirPieceJointe(Long id) {
        return pieceJointeRepository.findById(id).orElseThrow(() -> new RuntimeException("Pièce jointe non trouvée"));
    }

    public PieceJointe mettreAJourPieceJointe(PieceJointe pieceJointe) {
        if (pieceJointe.getId() == null || !pieceJointeRepository.existsById(pieceJointe.getId())) {
            throw new RuntimeException("Pièce jointe non trouvée pour mise à jour");
        }
        return pieceJointeRepository.save(pieceJointe);
    }

    public void supprimerPieceJointe(Long id) {
        if (!pieceJointeRepository.existsById(id)) {
            throw new RuntimeException("Pièce jointe non trouvée pour suppression");
        }
        pieceJointeRepository.deleteById(id);
    }
}


