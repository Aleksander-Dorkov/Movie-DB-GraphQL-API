package com.expence_tracking.app.services.implementations.user;

import com.expence_tracking.app.configuration.exceptions.PasswordMissMatchException;
import com.expence_tracking.app.configuration.exceptions.UserAlreadyExistsException;
import com.expence_tracking.app.configuration.security.jwt.JWTToken;
import com.expence_tracking.app.configuration.security.jwt.TokenProvider;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.binding.user.*;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.AuthorityRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.user.UserMutationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Service
@Validated
@RequiredArgsConstructor
public class UserMutationServiceImpl implements UserMutationService
{
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final TokenProvider tokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("isAnonymous()")
    public JWTToken createJWT(@Valid UserCreateJWT form)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        User user;
        String jwt;
        try
        {
            user = (User) authentication.getPrincipal();
        } catch (ClassCastException classCastException)
        {
            jwt = tokenProvider.createToken(authentication, form.getRememberMe(), -1);
            return new JWTToken(jwt);
        }
        jwt = tokenProvider.createToken(authentication, form.getRememberMe(), user.getUserId());
        return new JWTToken(jwt);

    }

    @Override
    @PreAuthorize("isAnonymous()")
    public Message createUser(@Valid UserCreate form)
    {
        if (this.userRepository.findByUsername(form.getUsername()) != null)
        {
            throw new UserAlreadyExistsException("User with this username is all ready registered");
        }
        User user = this.modelMapper.map(form, User.class);
        user.setRegistrationDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        user.getAuthorities().add(this.authorityRepository.getOne(form.getAuthorityId()));
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return new Message("Successfully registered");
    }

    @Override
    public Message updatePassword(@Valid UserUpdatePassword form) throws PasswordMissMatchException
    {
        User user = this.userRepository.findByUserId(form.getUserId());
        if (!this.passwordEncoder.matches(form.getOldPassword(), user.getPassword()))
        {
            throw new PasswordMissMatchException("The password you inputted doesnt match your current password");
        }
        user.setPassword(this.passwordEncoder.encode(form.getNewPassword()));
        this.userRepository.save(user);
        return new Message("Successfully changed password");
    }

    @Override
    public Message updateAccountLock(@Valid UserUpdateAccountLock form) throws PasswordMissMatchException
    {
        User user = this.userRepository.findByUserId(form.getUserId());
        if (!this.passwordEncoder.matches(form.getPassword(), user.getPassword()))
        {
            throw new PasswordMissMatchException("The password you inputted doesnt match your current password");
        }
        user.setAccountNonLocked(false);
        this.userRepository.save(user);
        return new Message("Successfully locked account");
    }

    @Override
    public Message updateAccountLockAdmin(@Valid AdminUpdateAccountLock form)
    {
        this.userRepository.updateAccountLock(form.getAccountNonLocked(), form.getUserId());
        String msg = form.getAccountNonLocked() ? "unlocked" : "locked";
        return new Message("Successfully " + msg + " the users account");
    }

    @Override
    public Message updateAuthorityAdmin(AdminUpdateAuthority form)
    {
        this.userRepository.updateAuthority(form.getUserId(), form.getAuthorityId());
        return new Message("Successfully changed the users authority");
    }
}
