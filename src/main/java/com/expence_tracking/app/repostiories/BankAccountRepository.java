package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.domain.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>
{
    List<BankAccount> findAllByOwner(User user);

    BankAccount findByBankAccountId(Long id);

    @Modifying
    @Transactional
    @Query("update bank_accounts set title=:title, description=:description, accountType=:accountType,initialBalance=:initialBalance where bankAccountId=:id")
    int updateBankAccount(@Param("title") String title,
                                  @Param("description") String description,
                                  @Param("accountType") AccountType accountType,
                                  @Param("initialBalance") BigDecimal initialBalance,
                                  @Param("id") Long id);
}
