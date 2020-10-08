package com.expence_tracking.app.services.iterfaces.authority;

import com.expence_tracking.app.domain.Authority;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface AuthorityQueryService extends GraphQLQueryResolver
{
    List<Authority> allAuthorities();
}
