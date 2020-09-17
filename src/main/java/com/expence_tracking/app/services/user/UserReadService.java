package com.expence_tracking.app.services.user;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

@Service
@RequiredArgsConstructor
public class UserReadService implements GraphQLQueryResolver
{
    private final UserRepository userRepository;

    public User getUserById(@Min(1) Long id)
    {
        return new User();
    }

}
