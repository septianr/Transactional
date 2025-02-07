package com.example.transaction.transaction.controller;

import com.example.transaction.transaction.domain.dto.TransferRequestDTO;
import com.example.transaction.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@Slf4j
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(value = "/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequestDTO request){
        return transactionService.transfer(request);
    }
}
