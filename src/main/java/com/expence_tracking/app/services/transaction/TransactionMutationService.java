package com.expence_tracking.app.services.transaction;

import com.expence_tracking.app.configuration.exceptions.GenericSQLException;
import com.expence_tracking.app.domain.BankAccount;
import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.domain.Transaction;
import com.expence_tracking.app.domain.enums.TransactionType;
import com.expence_tracking.app.dto.binding.transaction.ExpenseIncomeCreate;
import com.expence_tracking.app.dto.binding.transaction.TransactionUpdate;
import com.expence_tracking.app.dto.binding.transaction.TransferCreate;
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

    public Transaction createExpenseIncome(ExpenseIncomeCreate form)
    {
        Transaction transaction = this.modelMapper.map(form, Transaction.class);
        transaction.setBankAccount(this.bankAccountRepository.getOne(form.getBankAccountId()));
        transaction.setCategory(this.categoryRepository.getOne(form.getCategoryId()));
        Long id = this.transactionRepository.save(transaction).getTransactionId();
        return this.transactionRepository.findByTransactionId(id);
    }

    public Transaction updateExpenseIncome(TransactionUpdate form)
    {
        Category one = this.categoryRepository.getOne(form.getCategoryId());
        int i = this.transactionRepository.updateExpenseIncome(
                form.getNote(), form.getDate(),
                form.getType(), form.getBalance(), one,
                form.getTransactionId());
        if (i > 0)
        {
            return this.transactionRepository.findByTransactionId(form.getTransactionId());
        } else
        {
            throw new GenericSQLException("Something went wrong while executing the SQL statement");
        }
    }

    public Message deleteExpenseIncome(Long id)
    {
        this.transactionRepository.deleteExpenseIncome(id);
        return new Message("Successfully deleted");
    }


    public Transaction createTransfer(TransferCreate form)
    {
        BankAccount sender = this.bankAccountRepository.getOne(form.getSenderAccountId());
        BankAccount receiver = this.bankAccountRepository.getOne(form.getReceiverAccountId());

        Transaction expense = this.modelMapper.map(form, Transaction.class);
        expense.setType(TransactionType.EXPENSE);
        expense.setTransfer(true);
        expense.setBankAccount(sender);
        expense.setSenderAccount(sender);
        expense.setReceiverAccount(receiver);
        Long expanseId = this.transactionRepository.save(expense).getTransactionId();

        Transaction income = this.modelMapper.map(form, Transaction.class);
        income.setType(TransactionType.INCOME);
        income.setTransfer(true);
        income.setBankAccount(receiver);
        income.setSenderAccount(sender);
        income.setReceiverAccount(receiver);
        Long incomeId = this.transactionRepository.save(income).getTransactionId();

        this.transactionRepository.updateCorrespondingTransactionId(expanseId, incomeId);
        this.transactionRepository.updateCorrespondingTransactionId(incomeId, expanseId);


        return this.transactionRepository.findByTransactionId(expanseId);
    }

    public Message deleteTransfer(Long id)
    {
        this.transactionRepository.deleteById(id);
        return new Message("Successfully deleted");
    }
}
