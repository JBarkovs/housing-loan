package com.example.loanserver.loan;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanTypeDao {
    public double getLoanTypeInterestRate(Long loanTypeId) {
        //TODO get real value by loanTypeId
        return 3.5;
    }
}
