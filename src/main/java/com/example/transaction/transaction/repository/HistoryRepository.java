package com.example.transaction.transaction.repository;

import com.example.transaction.transaction.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
    
}
