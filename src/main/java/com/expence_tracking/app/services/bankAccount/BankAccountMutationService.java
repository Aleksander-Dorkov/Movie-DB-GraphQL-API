package com.expence_tracking.app.services.bankAccount;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.dto.bindings.bank_account.BankAccountCreateForm;
import com.expence_tracking.app.dto.bindings.bank_account.BankAccountEditForm;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BankAccountMutationService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final ModelMapper modelMapper;

    public Message createBankAccount(BankAccountCreateForm form)
    {

        BankAccount bankAccount = this.modelMapper.map(form, BankAccount.class);
        bankAccount.setCreationDate(LocalDateTime.now());
        bankAccount.setOwner(this.userRepository.getOne(form.getUserId()));
        bankAccount.setCurrentBalance(form.getInitialBalance());
        this.bankAccountRepository.save(bankAccount);
        return new Message("Successfully added a new account");
    }

    public Message updateBankAccount(BankAccountEditForm form)
    {
        this.bankAccountRepository.updateBankAccount(
                form.getTitle(), form.getDescription(),
                form.getAccountType(), form.getInitialBalance(),
                form.getBankAccountId());
        return new Message("Successfully edited your account");
    }
}
