package com.example.transaction.domain.model;

import com.example.transaction.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction_history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private TransactionType transactionType;

    @Column(length = 10)
    private String accountNumber;

    private BigDecimal amount;

    private Date transactionDate;


}
