package com.expence_tracking.app.services.transaction;

import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.Transaction;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.TransactionRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionQueryService implements GraphQLQueryResolver
{
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public Transaction getByTransactionId(Long id)
    {
        return this.transactionRepository.findByTransactionId(id);
    }

    public List<Transaction> getAllTransactionsByBankAccountId(Long id)
    {
        System.out.println("tuka sme @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        BankAccount one = this.bankAccountRepository.getOne(id);
        return this.transactionRepository.findAllByBankAccount(one);
    }

    public List<Transaction> getAllTransactionsByByUserId(Long id)
    {
        List<BankAccount> bankAccounts = this.transactionRepository
                .findAllBankAccountIdsForUser(id).stream()
                .map(this.bankAccountRepository::getOne)
                .collect(Collectors.toList());
        return this.transactionRepository.findAllByBankAccountIn(bankAccounts);

    }
}
