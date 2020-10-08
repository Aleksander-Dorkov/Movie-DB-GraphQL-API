package com.expence_tracking.app.services.iterfaces.user;

import com.expence_tracking.app.configuration.exceptions.PasswordMissMatchException;
import com.expence_tracking.app.configuration.security.jwt.JWTToken;
import com.expence_tracking.app.dto.binding.user.*;
import com.expence_tracking.app.dto.view.Message;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;

public interface UserMutationService extends GraphQLMutationResolver
{
    @PreAuthorize("isAnonymous()")
    JWTToken createJWT(@Valid UserCreateJWT form);

    @PreAuthorize("isAnonymous()")
    Message createUser(@Valid UserCreate form);

    Message updatePassword(@Valid UserUpdatePassword form) throws PasswordMissMatchException;

    Message updateAccountLock(@Valid UserUpdateAccountLock form) throws PasswordMissMatchException;

    Message updateAccountLockAdmin(@Valid AdminUpdateAccountLock form);

    Message updateAuthorityAdmin(AdminUpdateAuthority form);
}
