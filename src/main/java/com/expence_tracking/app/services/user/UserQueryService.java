package com.expence_tracking.app.services.user;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class UserQueryService implements GraphQLQueryResolver
{
    private final UserRepository userRepository;

    public User userById(@Min(1) Long id)
    {
        return this.userRepository.findByUserId(id);
    }

    public List<User> allUsers()
    {
        return this.userRepository.findAllBy();
    }

}
