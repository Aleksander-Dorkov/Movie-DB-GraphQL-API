package com.expence_tracking.app.services.implementations.authority;

import com.expence_tracking.app.domain.Authority;
import com.expence_tracking.app.repostiories.AuthorityRepository;
import com.expence_tracking.app.services.iterfaces.authority.AuthorityQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorityQueryServiceImpl implements AuthorityQueryService {

    private final AuthorityRepository authorityRepository;

    @Override
    public List<Authority> allAuthorities() {
        return this.authorityRepository.findAll();
    }
}
