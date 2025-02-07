package com.example.transaction.transaction.service;

import com.example.transaction.transaction.dto.HistoryDTO;
import com.example.transaction.transaction.model.History;
import com.example.transaction.transaction.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponseEntity<?> sendHistory(HistoryDTO request){

        History history = new History();

        try {
            history.setName(request.getName());
            history.setAccountNumber(request.getAccountNumber());
            history.setBalance(request.getBalance());
            historyRepo.save(history);
            return ResponseEntity.ok(history);
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        } finally {
            rabbitTemplate.convertAndSend("TransactionQueue", request);
        }

    }
}
