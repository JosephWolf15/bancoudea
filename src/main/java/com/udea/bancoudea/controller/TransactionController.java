package com.udea.bancoudea.controller;

import com.udea.bancoudea.DTO.TransactionDTO;
import com.udea.bancoudea.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) { this.transactionService = transactionService; }

    @GetMapping("/{accountnumber}")
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable("accountnumber") String accountNumber){
        return ResponseEntity.ok(transactionService.getTransactionsForAccount(accountNumber));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok(transactionService.transferMoney(transactionDTO));
    }
}
