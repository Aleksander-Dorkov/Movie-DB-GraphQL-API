package com.expence_tracking.app.services.implementations.user;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.user.UserQueryService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    @PreAuthorize("isAuthenticated()")
    public User userById(@Min(1) Long id) {
        return this.userRepository.findByUserId(id);
    }

    @Override
    @PreAuthorize("hasAnyAuthority(ROLE_ADMIN)")
    public List<User> allUsers() {
        return this.userRepository.findAllBy();
    }

}
