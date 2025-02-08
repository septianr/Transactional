package com.example.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction.domain.model.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
    
}
