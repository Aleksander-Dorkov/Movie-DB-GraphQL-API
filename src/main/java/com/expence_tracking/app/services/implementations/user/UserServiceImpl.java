package com.expence_tracking.app.services.implementations.user;

import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return this.userRepository.findByUsername(username);
    }
}
