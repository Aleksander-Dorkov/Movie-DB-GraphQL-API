package com.expence_tracking.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String password;
    private String username;
    private Date registrationDate;
    private Boolean accountNonLocked;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "authorityId"))
    private Set<Authority> authorities;

    public User()
    {
        this.authorities = new HashSet<>();
    }

    public Set<Authority> getAuthorities()
    {
        return this.authorities;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public boolean isAccountNonLocked()
    {
        return this.accountNonLocked;
    }

    public boolean isAccountNonExpired()
    {
        return true;
    }

    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    public boolean isEnabled()
    {
        return true;
    }
}
