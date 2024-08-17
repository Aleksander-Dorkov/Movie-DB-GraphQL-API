package com.expence_tracking.app.services.iterfaces.user;

import com.expence_tracking.app.domain.User;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Min;
import java.util.List;

@Controller
public interface UserQueryService {

    @QueryMapping
    User userById(@Min(1) Long id);

    @QueryMapping
    List<User> allUsers();
}
