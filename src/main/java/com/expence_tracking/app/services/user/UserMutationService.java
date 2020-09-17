package com.expence_tracking.app.services.user;

import com.expence_tracking.app.configuration.exceptions.PasswordMissMatchException;
import com.expence_tracking.app.configuration.exceptions.UserAlreadyExistsException;
import com.expence_tracking.app.configuration.security.jwt.JWTToken;
import com.expence_tracking.app.configuration.security.jwt.TokenProvider;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.bindings.user.ChangePasswordForm;
import com.expence_tracking.app.dto.bindings.user.LockAccountForm;
import com.expence_tracking.app.dto.bindings.user.LoginForm;
import com.expence_tracking.app.dto.bindings.user.RegistrationForm;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.AuthorityRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
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
import java.util.Date;

@Service
@RequiredArgsConstructor
@Validated
public class UserMutationService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final TokenProvider tokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("isAnonymous()")
    public JWTToken authenticate(LoginForm form)
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

    @PreAuthorize("isAnonymous()")
    public User register(@Valid RegistrationForm form)
    {
        if (this.userRepository.findByUsername(form.getUsername()) != null)
        {
            throw new UserAlreadyExistsException("User with this username is all ready registered");
        }
        User user = this.modelMapper.map(form, User.class);
        user.setRegistrationDate(new Date());
        user.setAccountNonLocked(true);
        user.getAuthorities().add(this.authorityRepository.getOne(1L));
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return user;
    }

    public Message changePassword(ChangePasswordForm form) throws PasswordMissMatchException
    {
        User user = this.userRepository.findByUserId(form.getUserId());
        if (!user.getPassword().equals(this.bCryptPasswordEncoder.encode(form.getOldPassword())))
        {
            throw new PasswordMissMatchException("The password you inputted doesnt match your current password");
        }
        user.setPassword(this.bCryptPasswordEncoder.encode(form.getNewPassword()));
        this.userRepository.save(user);
        return new Message("Successfully change password");
    }

    public Message lockAccount(LockAccountForm form) throws PasswordMissMatchException
    {
        User user = this.userRepository.findByUserId(form.getUserId());
        if (!user.getPassword().equals(this.bCryptPasswordEncoder.encode(form.getPassword())))
        {
            throw new PasswordMissMatchException("The password you inputted doesnt match your current password");
        }
        user.setAccountNonLocked(false);
        return new Message("Successfully locked account");
    }

}
