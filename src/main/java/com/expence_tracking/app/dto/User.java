package com.expence_tracking.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String password;
    private String username;
    private Boolean accountNonLocked;
    @ManyToMany
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "authority_id",referencedColumnName = "authorityId"))
    private Set<Authority> authorities;

    @Override
    public Set<Authority> getAuthorities()
    {
        return this.authorities;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return this.accountNonLocked;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
