package com.example.loanserver.housing;

import com.example.loanserver.loan.Loan;
import com.example.loanserver.loan.LoanParams;
import com.example.loanserver.loan.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class HousingService {

    private final LoanService loanService;

    public Loan getHousingLoanCost(LoanParams params) {
        return loanService.getLoan(params, calculateHousingLoan());
    }

    public BiFunction<LoanParams, Double, Loan> calculateHousingLoan() {
        return (params, interest) -> {
            Double monthlyRate = interest / ( 12 * 100 );
            Integer periodMonths = params.getPeriodYears() * 12;
            //[P * R * (1 + R)^N] / [(1 + R)^N - 1]
            Double monthlyPayment = (params.getPrincipleAmount() * monthlyRate * Math.pow(1 + monthlyRate, periodMonths))
                                    / (Math.pow(1 + monthlyRate, periodMonths) - 1);
            return Loan.builder()
                    .monthlyPayment(monthlyPayment)
                    .principleAmount(params.getPrincipleAmount())
                    .interestAmount(monthlyPayment * periodMonths - params.getPrincipleAmount())
                    .build();
        };
    }
}
