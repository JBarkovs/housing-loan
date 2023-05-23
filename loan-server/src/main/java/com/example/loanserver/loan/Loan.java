package com.example.loanserver.loan;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loan {
    private Double monthlyPayment;
    private Double principleAmount;
    private Double interestAmount;
}
