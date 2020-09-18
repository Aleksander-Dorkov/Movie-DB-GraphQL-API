package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "bank_accounts")
public class BankAccount
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_account_generator")
    @SequenceGenerator(name = "bank_account_generator", sequenceName = "bank_account_seq", allocationSize = 1)
    private Long bankAccountId;
    private String title;
    private String description;
    private AccountType accountType;
    private BigDecimal startingBalance;
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User userId;
}
