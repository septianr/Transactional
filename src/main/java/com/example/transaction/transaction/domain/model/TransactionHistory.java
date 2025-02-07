package com.example.transaction.transaction.domain.model;

import com.example.transaction.transaction.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "transaction_history")
@NoArgsConstructor
@AllArgsConstructor
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
