package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
