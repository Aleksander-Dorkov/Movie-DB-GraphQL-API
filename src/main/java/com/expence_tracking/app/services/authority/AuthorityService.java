package com.expence_tracking.app.services.authority;

import com.expence_tracking.app.domain.Authority;
import com.expence_tracking.app.repostiories.AuthorityRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorityService implements GraphQLQueryResolver
{
    private final AuthorityRepository authorityRepository;

    public List<Authority> allAuthorities()
    {
        return this.authorityRepository.findAll();
    }
}
