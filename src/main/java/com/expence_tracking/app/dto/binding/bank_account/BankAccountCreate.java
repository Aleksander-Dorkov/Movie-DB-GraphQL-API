package com.expence_tracking.app.dto.binding.bank_account;

import com.expence_tracking.app.domain.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BankAccountCreate
{
    private Long userId;
    private String title;
    private String description;
    private AccountType accountType;
    private BigDecimal initialBalance;
}
