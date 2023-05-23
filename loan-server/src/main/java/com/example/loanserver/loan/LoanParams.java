package com.example.loanserver.loan;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanParams {
    private Long loanTypeId;
    private Integer periodYears;
    private Double principleAmount;
}
