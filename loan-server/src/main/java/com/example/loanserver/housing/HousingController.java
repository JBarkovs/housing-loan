package com.example.loanserver.housing;

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
    public HousingLoan getLoanCost(LoanParams params) {
        return service.getHousingCost(params);
    }
    
}
