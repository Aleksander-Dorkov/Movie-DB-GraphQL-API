package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.domain.Transaction;
import com.expence_tracking.app.domain.enums.TransactionType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
    @EntityGraph("fetchAll")
    Transaction findByTransactionId(Long id);

    @EntityGraph("fetchAll")
    List<Transaction> findAllByBankAccount(BankAccount bankAccount);

    //    find all bank account ids for user
    @Query(value = "select bank_account_id from bank_accounts where user_id=:userId", nativeQuery = true)
    List<Long> findAllBankAccountIdsForUser(@Param("userId") Long userId);

    @EntityGraph("fetchAll")
    List<Transaction> findAllByBankAccountIn(List<BankAccount> bankAccounts);

    @Modifying
    @Transactional
    @Query("update Transaction set note=:note, date=:date, type=:type, balance=:balance, category=:category where transactionId=:id")
    int updateExpenseIncome(@Param("note") String note,
                            @Param("date") LocalDateTime date,
                            @Param("type") TransactionType type,
                            @Param("balance") BigDecimal balance,
                            @Param("category") Category category,
                            @Param("id") Long id);
}
