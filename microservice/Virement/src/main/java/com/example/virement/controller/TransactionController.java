package com.example.virement.controller;

import com.example.virement.model.PieceJointe;
import com.example.virement.model.Transaction;
import com.example.virement.repository.TransactionRepository;
import com.example.virement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Virement")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/saveTransaction")
    public ResponseEntity<Transaction> ajouterTransaction(@RequestBody Transaction transaction) {
//        Transaction nouvelleTransaction = transactionService.ajouterTransaction(transaction);
        Transaction newTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/getAllTransactions")
    public ResponseEntity<List<Transaction>> findAll() {
//        Transaction nouvelleTransaction = transactionService.ajouterTransaction(transaction);
        List<Transaction> transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<Transaction>> getByIdUser(@PathVariable("id") Long id) {
//        Transaction nouvelleTransaction = transactionService.ajouterTransaction(transaction);
        List<Transaction> transactions = transactionRepository.findByCompteNumber(id);
        return new ResponseEntity<>(transactions, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> obtenirTransaction(@PathVariable("id") Long id) {
        Transaction transaction = transactionService.obtenirTransaction(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> mettreAJourTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        transaction.setId(id);
        Transaction transactionMiseAJour = transactionService.mettreAJourTransaction(transaction);
        return new ResponseEntity<>(transactionMiseAJour, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTransaction(@PathVariable("id") Long id) {
        transactionService.supprimerTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{transactionId}/pieces-jointes")
    public ResponseEntity<PieceJointe> ajouterPieceJointe(@PathVariable("transactionId") Long transactionId, @RequestBody PieceJointe pieceJointe) {
        PieceJointe nouvellePieceJointe = transactionService.ajouterPieceJointe(transactionId, pieceJointe);
        return new ResponseEntity<>(nouvellePieceJointe, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionId}/pieces-jointes")
    public ResponseEntity<List<PieceJointe>> obtenirPiecesJointesParTransaction(@PathVariable("transactionId") Long transactionId) {
        List<PieceJointe> piecesJointes = transactionService.obtenirPiecesJointesParTransaction(transactionId);
        return new ResponseEntity<>(piecesJointes, HttpStatus.OK);
    }
}
