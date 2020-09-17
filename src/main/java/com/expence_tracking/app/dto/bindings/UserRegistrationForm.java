package com.expence_tracking.app.dto.bindings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationForm
{
    @Size(min = 5)
    private String username;
    @Size(min = 5)
    private String password;
    @Size(min = 5)
    private String confirmPassword;
}
