package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>
{
    List<BankAccount> findAllByOwner(User user);

    BankAccount findByBankAccountId(Long id);
}
