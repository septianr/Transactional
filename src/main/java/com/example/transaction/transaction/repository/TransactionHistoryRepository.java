package com.example.transaction.transaction.repository;

import com.example.transaction.transaction.domain.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
    
}
