package com.expence_tracking.app.services.bankAccount;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService implements GraphQLQueryResolver
{
    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public List<BankAccount> getAllBankAccountsByUserId(Long id)
    {
        return this.bankAccountRepository.findAllByOwner(this.userRepository.getOne(id));
    }

    public BankAccount getBankAccountById(Long id)
    {
        return this.bankAccountRepository.findByBankAccountId(id);
    }

}
