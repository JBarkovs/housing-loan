package com.example.loanserver.loan;

import org.springframework.stereotype.Component;

@Component
public class LoanTypeDao {
    public Double getLoanTypeInterestRate(Long loanTypeId) {
        //TODO get real value by loanTypeId
        return 3.5;
    }
}
