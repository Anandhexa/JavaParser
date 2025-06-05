package com.banking.controller;

import com.banking.dto.*;
import com.banking.service.BankingService;
import com.banking.exception.InsufficientFundsException;
import com.banking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/banking")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    // Get account details
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<AccountDTO> getAccountDetails(@PathVariable String accountId) {
        AccountDTO account = bankingService.getAccountDetails(accountId);
        return ResponseEntity.ok(account);
    }

    // Get account balance
    @GetMapping("/accounts/{accountId}/balance")
    public ResponseEntity<BalanceDTO> getAccountBalance(@PathVariable String accountId) {
        BalanceDTO balance = bankingService.getAccountBalance(accountId);
        return ResponseEntity.ok(balance);
    }

    // Get transaction history with pagination and filtering
    @GetMapping("/accounts/{accountId}/transactions")
    public ResponseEntity<TransactionResponseDTO> getTransactionHistory(
            @PathVariable String accountId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String transactionType) {
        
        TransactionResponseDTO transactions = bankingService.getTransactionHistory(
            accountId, page, size, startDate, endDate, transactionType);
        return ResponseEntity.ok(transactions);
    }

    // Create new transaction
    @PostMapping("/transactions")
    public ResponseEntity<TransactionDTO> createTransaction(
            @Valid @RequestBody TransactionRequestDTO transactionRequest) {
        TransactionDTO transaction = bankingService.createTransaction(transactionRequest);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    // Fund transfer between accounts
    @PostMapping("/transfers")
    public ResponseEntity<TransferResponseDTO> transferFunds(
            @Valid @RequestBody TransferRequestDTO transferRequest) {
        TransferResponseDTO transfer = bankingService.transferFunds(transferRequest);
        return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    }

    // Update account information
    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<AccountDTO> updateAccountInformation(
            @PathVariable String accountId,
            @Valid @RequestBody AccountUpdateDTO updateRequest) {
        AccountDTO updatedAccount = bankingService.updateAccountInformation(accountId, updateRequest);
        return ResponseEntity.ok(updatedAccount);
    }

    // Create new beneficiary
    @PostMapping("/accounts/{accountId}/beneficiaries")
    public ResponseEntity<BeneficiaryDTO> addBeneficiary(
            @PathVariable String accountId,
            @Valid @RequestBody BeneficiaryRequestDTO beneficiaryRequest) {
        BeneficiaryDTO beneficiary = bankingService.addBeneficiary(accountId, beneficiaryRequest);
        return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
    }

    // Get all beneficiaries
    @GetMapping("/accounts/{accountId}/beneficiaries")
    public ResponseEntity<List<BeneficiaryDTO>> getBeneficiaries(@PathVariable String accountId) {
        List<BeneficiaryDTO> beneficiaries = bankingService.getBeneficiaries(accountId);
        return ResponseEntity.ok(beneficiaries);
    }

    // Delete beneficiary
    @DeleteMapping("/accounts/{accountId}/beneficiaries/{beneficiaryId}")
    public ResponseEntity<Void> deleteBeneficiary(
            @PathVariable String accountId,
            @PathVariable String beneficiaryId) {
        bankingService.deleteBeneficiary(accountId, beneficiaryId);
        return ResponseEntity.noContent().build();
    }

    // Get account statements
    @GetMapping("/accounts/{accountId}/statements")
    public ResponseEntity<List<StatementDTO>> getAccountStatements(
            @PathVariable String accountId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        List<StatementDTO> statements = bankingService.getAccountStatements(accountId, startDate, endDate);
        return ResponseEntity.ok(statements);
    }