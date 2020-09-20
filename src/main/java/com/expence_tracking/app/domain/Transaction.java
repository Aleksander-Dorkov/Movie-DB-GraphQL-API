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
@NamedEntityGraphs({
        @NamedEntityGraph(name = "fetchAll", attributeNodes = {
                @NamedAttributeNode("bankAccount"),
                @NamedAttributeNode("receiverAccount"),
                @NamedAttributeNode("category")
        })
})
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generation")
    @SequenceGenerator(name = "transaction_generation", sequenceName = "transaction_seq", allocationSize = 1)
    private Long transactionId;
    private String note;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category; //possible null
    private String subCategoryName; //possible null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "bankAccountId", nullable = false)
    private BankAccount bankAccount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id", referencedColumnName = "bankAccountId")
    private BankAccount receiverAccount; //possible null

    //fornt end if(type == transfer) category + subCategoryName == transfer and bankAcc-->transfer acc instead of type

}
