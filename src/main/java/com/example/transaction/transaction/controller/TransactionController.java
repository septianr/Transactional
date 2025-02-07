package com.example.transaction.transaction.controller;

import com.example.transaction.transaction.dto.HistoryDTO;
import com.example.transaction.transaction.service.HistoryService;
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
    private HistoryService historyService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveHistory(@RequestBody HistoryDTO request){
        return historyService.sendHistory(request);
    }
}
