package com.expence_tracking.app.services.bankAccount;

import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountMutationService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;

    public Message newBankAccount()
    {
        return new Message("");
    }
}
