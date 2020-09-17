package com.expence_tracking.app.services.user;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.bindings.UserLoginForm;
import com.expence_tracking.app.dto.bindings.UserRegistrationForm;
import com.expence_tracking.app.repostiories.AuthorityRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Validated
public class UserWriteService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final ModelMapper modelMapper;


    public User login(UserLoginForm user)
    {

        return new User();
    }

    public User register(@Valid UserRegistrationForm form)
    {
        User user = this.modelMapper.map(form, User.class);
        user.setRegistrationDate(new Date());
        user.setAccountNonLocked(true);
        user.getAuthorities().add(this.authorityRepository.getOne(1L));
        this.userRepository.save(user);
        return user;
    }
}
