package com.example.loanserver.housing;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HousingService {

    public HousingLoan getHousingCost(LoanParams params) {
        return HousingLoan.builder()
                .monthlyPayment(BigDecimal.valueOf(0))
                .build();
    }
}
