package com.example.transaction.service;

import com.example.transaction.domain.dto.TransferRequestDTO;
import com.example.transaction.domain.enums.TransactionType;
import com.example.transaction.domain.model.TransactionHistory;
import com.example.transaction.repository.TransactionHistoryRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TransactionService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponseEntity<?> transfer(TransferRequestDTO request){


        try {
            //logic transfer
            //submit transfer to dest account
            //etc

            //save to transaction history
            saveTransactionHistory(request);
            return ResponseEntity.ok(request);
        } catch (Exception e){
            return null;
        } finally {
            rabbitTemplate.convertAndSend("TransactionQueue", request);
        }

    }

    public void saveTransactionHistory(TransferRequestDTO request) {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setName(request.getName());
        transactionHistory.setTransactionType(TransactionType.TRANSFER);
        transactionHistory.setAccountNumber(request.getAccountNumber());
        transactionHistory.setAmount(request.getAmount());
        transactionHistory.setTransactionDate(new Date());
        transactionHistoryRepository.save(transactionHistory);
    }
}
