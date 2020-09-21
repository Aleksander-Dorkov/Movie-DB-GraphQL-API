package com.expence_tracking.app.services.bankAccount;

import com.expence_tracking.app.configuration.exceptions.GenericSQLException;
import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.dto.binding.bank_account.BankAccountCreate;
import com.expence_tracking.app.dto.binding.bank_account.BankAccountEdit;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.TransactionRepository;
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
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public BankAccount createBankAccount(BankAccountCreate form)
    {

        BankAccount bankAccount = this.modelMapper.map(form, BankAccount.class);
        bankAccount.setCreationDate(LocalDateTime.now());
        bankAccount.setOwner(this.userRepository.getOne(form.getUserId()));
        Long bankAccountId = this.bankAccountRepository.save(bankAccount).getBankAccountId();
        return this.bankAccountRepository.findByBankAccountId(bankAccountId);
    }

    public BankAccount updateBankAccount(BankAccountEdit form) throws GenericSQLException
    {
        int rows = this.bankAccountRepository.updateBankAccount(
                form.getTitle(), form.getDescription(),
                form.getAccountType(), form.getInitialBalance(),
                form.getBankAccountId());
        if (rows > 0)
        {
            return this.bankAccountRepository.findByBankAccountId(form.getBankAccountId());
        } else
        {
            throw new GenericSQLException("Something went wrong while executing sql");
        }
    }
}
