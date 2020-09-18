package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.TransactionSubType;
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
    private String memo;
    private LocalDateTime creationDate;
    private TransactionType type;
    private TransactionSubType subtype;
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "bankAccountId", nullable = false)
    private BankAccount bankAccountId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "bankAccountId")
    private BankAccount receiverId;

}
