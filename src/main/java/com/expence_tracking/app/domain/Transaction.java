package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "transactions")
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generation")
    @SequenceGenerator(name = "transaction_generation", sequenceName = "transaction_seq", allocationSize = 1)
    private Long transactionId;
    private String note;
    private LocalDateTime creationDate;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregory_id", referencedColumnName = "categoryId", nullable = false)
    private Category category;
    private String categoryName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "bankAccountId", nullable = false)
    private BankAccount bankAccount;
    @ManyToOne(fetch = FetchType.LAZY) //possible null
    @JoinColumn(name = "transfer_account_id", referencedColumnName = "bankAccountId")
    private BankAccount transferAccount;

}
