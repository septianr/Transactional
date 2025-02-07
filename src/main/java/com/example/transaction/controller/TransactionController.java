package com.example.transaction.controller;

import com.example.transaction.domain.dto.TransferRequestDTO;
import com.example.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequestDTO request){
        return transactionService.transfer(request);
    }
}
