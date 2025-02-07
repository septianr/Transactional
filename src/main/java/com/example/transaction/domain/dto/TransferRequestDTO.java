package com.example.transaction.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
public class TransferRequestDTO {

    private String name;
    private String accountNumber;
    private BigDecimal amount;
}
