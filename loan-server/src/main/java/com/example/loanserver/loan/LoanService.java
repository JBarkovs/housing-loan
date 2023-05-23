package com.example.loanserver.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanTypeDao loanTypeDao;

    public Loan getLoan(LoanParams params, BiFunction<LoanParams, Double, Loan> calculateLoan) {
        Double interestRate = loanTypeDao.getLoanTypeInterestRate(params.getLoanTypeId());
        return calculateLoan.apply(params, interestRate);
    }
}
