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
public class BankAccountQueryService implements GraphQLQueryResolver
{
    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public BankAccount bankAccountById(Long id)
    {
        return this.bankAccountRepository.findByBankAccountId(id);
    }

    public List<BankAccount> allBankAccountsByUserId(Long id)
    {
        return this.bankAccountRepository.findAllByOwner(this.userRepository.getOne(id));
    }

}
