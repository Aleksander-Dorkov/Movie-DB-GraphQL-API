package com.expence_tracking.app.services.iterfaces.user;

import com.expence_tracking.app.configuration.exceptions.PasswordMissMatchException;
import com.expence_tracking.app.configuration.security.jwt.JWTToken;
import com.expence_tracking.app.dto.binding.user.AdminUpdateAccountLock;
import com.expence_tracking.app.dto.binding.user.AdminUpdateAuthority;
import com.expence_tracking.app.dto.binding.user.UserCreate;
import com.expence_tracking.app.dto.binding.user.UserCreateJWT;
import com.expence_tracking.app.dto.binding.user.UserUpdateAccountLock;
import com.expence_tracking.app.dto.binding.user.UserUpdatePassword;
import com.expence_tracking.app.dto.view.Message;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public interface UserMutationService {

    @MutationMapping
    @PreAuthorize("isAnonymous()")
    JWTToken createJWT(@Argument("form") @Valid UserCreateJWT form);

    @MutationMapping
    @PreAuthorize("isAnonymous()")
    Message createUser(@Argument("form") @Valid UserCreate form);

    @MutationMapping
    Message updatePassword(@Argument("form") @Valid UserUpdatePassword form) throws PasswordMissMatchException;

    @MutationMapping
    Message updateAccountLock(@Argument("form") @Valid UserUpdateAccountLock form) throws PasswordMissMatchException;

    @MutationMapping
    Message updateAccountLockAdmin(@Argument("form") @Valid AdminUpdateAccountLock form);

    @MutationMapping
    Message updateAuthorityAdmin(@Argument("form") AdminUpdateAuthority form);
}
