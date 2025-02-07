package com.example.transaction.transaction.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDTO {

    private String name;
    private String accountNumber;
    private BigDecimal amount;
}
