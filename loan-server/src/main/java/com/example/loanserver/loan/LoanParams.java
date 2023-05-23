package com.example.loanserver.loan;

import lombok.Data;

@Data
public class LoanParams {
    private Long loanTypeId;
    private Integer periodYears;
    private Double principleAmount;
}
