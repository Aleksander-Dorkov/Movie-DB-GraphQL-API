package com.expence_tracking.app.services.transaction;

import com.expence_tracking.app.domain.Transaction;
import com.expence_tracking.app.dto.binding.transaction.ExpenseIncomeCreate;
import com.expence_tracking.app.repostiories.BankAccountRepository;
import com.expence_tracking.app.repostiories.CategoryRepository;
import com.expence_tracking.app.repostiories.TransactionRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionMutationService implements GraphQLMutationResolver
{
    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public Transaction createExpenseIncome(ExpenseIncomeCreate form)
    {
        Transaction transaction = this.modelMapper.map(form, Transaction.class);
        transaction.setBankAccount(this.bankAccountRepository.getOne(form.getBankAccountId()));
        transaction.setCategory(this.categoryRepository.getOne(form.getCategoryId()));
        Long id = this.transactionRepository.save(transaction).getTransactionId();
        return this.transactionRepository.findByTransactionId(id);
    }
}
