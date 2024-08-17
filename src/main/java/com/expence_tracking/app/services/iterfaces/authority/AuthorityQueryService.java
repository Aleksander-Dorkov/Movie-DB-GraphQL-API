package com.expence_tracking.app.services.iterfaces.authority;

import com.expence_tracking.app.domain.Authority;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface AuthorityQueryService
{
    @QueryMapping
    List<Authority> allAuthorities();
}
