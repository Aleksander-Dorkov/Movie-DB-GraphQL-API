package com.expence_tracking.app.services.transaction;

import com.expence_tracking.app.domain.Transaction;
import com.expence_tracking.app.dto.binding.transaction.ExpenseIncomeForm;
import com.expence_tracking.app.dto.view.Message;
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

    public Message createExpenseIncome(ExpenseIncomeForm form)
    {
        Transaction transaction = this.modelMapper.map(form, Transaction.class);
        transaction.setBankAccount(this.bankAccountRepository.getOne(form.getBankAccountId()));
        transaction.setCategory(this.categoryRepository.getOne(form.getCategoryId()));
        this.transactionRepository.save(transaction);
        return new Message("");
    }
}
