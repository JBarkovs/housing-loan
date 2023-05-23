package com.example.loanserver.housing;

import com.example.loanserver.loan.Loan;
import com.example.loanserver.loan.LoanParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("housing")
@RequiredArgsConstructor
public class HousingController {

    private final HousingService service;

    @GetMapping
    public Loan getLoanCost(LoanParams params) {
        return service.getHousingLoanCost(params);
    }
    
}
