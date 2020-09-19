package com.expence_tracking.app.services.bankAccount;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.dto.bindings.bank_account.BankAccountCreateForm;
import com.expence_tracking.app.dto.bindings.bank_account.BankAccountEditForm;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BankAccountMutationService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final ModelMapper modelMapper;

    public BankAccount newBankAccount(BankAccountCreateForm form)
    {

        BankAccount bankAccount = this.modelMapper.map(form, BankAccount.class);
        bankAccount.setCreationDate(LocalDateTime.now());
        bankAccount.setOwner(this.userRepository.getOne(form.getUserId()));
        return this.bankAccountRepository.save(bankAccount);
    }

    public BankAccount editBankAccount(BankAccountEditForm form)
    {
        BankAccount bankAccount = this.modelMapper.map(form, BankAccount.class);
        return this.bankAccountRepository.save(bankAccount);
    }
}
