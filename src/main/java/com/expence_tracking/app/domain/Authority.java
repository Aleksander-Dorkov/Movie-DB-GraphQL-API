package com.expence_tracking.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authorities")
public class Authority implements GrantedAuthority
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_generator")
    @SequenceGenerator(name = "authority_generator", sequenceName = "authority_seq", allocationSize = 1)
    private Long authorityId;
    private String authority;

    @Override
    public String getAuthority()
    {
        return this.authority;
    }
}
