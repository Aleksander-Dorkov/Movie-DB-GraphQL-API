package com.expence_tracking.app.services;

import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReadService implements GraphQLQueryResolver
{
    private final UserRepository userRepository;

}
