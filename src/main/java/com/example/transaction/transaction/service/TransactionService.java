package com.example.transaction.transaction.service;

import com.example.transaction.transaction.domain.dto.TransferRequestDTO;
import com.example.transaction.transaction.domain.enums.TransactionType;
import com.example.transaction.transaction.domain.model.TransactionHistory;
import com.example.transaction.transaction.repository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionHistoryRepository transactionHistoryRepository;
    private final RabbitTemplate rabbitTemplate;

    public ResponseEntity<?> transfer(TransferRequestDTO request){


        try {
            //logic transfer
            //submit transfer to dest account
            //etc

            //save to transaction history
            saveTransactionHistory(request);
            return ResponseEntity.ok(request);
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        } finally {
            rabbitTemplate.convertAndSend("TransactionQueue", request);
        }

    }

    private void saveTransactionHistory(TransferRequestDTO request) {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setName(request.getName());
        transactionHistory.setTransactionType(TransactionType.TRANSFER);
        transactionHistory.setAccountNumber(request.getAccountNumber());
        transactionHistory.setAmount(request.getAmount());
        transactionHistory.setTransactionDate(new Date());
        transactionHistoryRepository.save(transactionHistory);
    }
}
