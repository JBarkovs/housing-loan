package com.example.loanserver.housing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LoanParams {
    private BigDecimal interestRate;
    private BigDecimal principleAmount;
    private Integer periodMonths;
}
