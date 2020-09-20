package com.expence_tracking.app.services.transaction;

import com.expence_tracking.app.repostiories.BankAccountRepository;
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
    private final ModelMapper modelMapper;


}
