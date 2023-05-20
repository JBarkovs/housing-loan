package com.example.loanserver.housing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class HousingLoan {
    private BigDecimal monthlyPayment;
}
