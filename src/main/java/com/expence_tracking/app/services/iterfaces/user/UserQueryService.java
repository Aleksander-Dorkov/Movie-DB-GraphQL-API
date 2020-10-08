package com.expence_tracking.app.services.iterfaces.user;

import com.expence_tracking.app.domain.User;
import graphql.kickstart.tools.GraphQLQueryResolver;

import javax.validation.constraints.Min;
import java.util.List;

public interface UserQueryService extends GraphQLQueryResolver
{
    User userById(@Min(1) Long id);

    List<User> allUsers();
}
