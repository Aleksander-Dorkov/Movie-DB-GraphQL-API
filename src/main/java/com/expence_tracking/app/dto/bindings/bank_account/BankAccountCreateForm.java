package com.expence_tracking.app.dto.bindings.bank_account;

import com.expence_tracking.app.domain.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BankAccountCreateForm
{
    private String title;
    private String description;
    private AccountType accountType;
    private BigDecimal balance;
}
