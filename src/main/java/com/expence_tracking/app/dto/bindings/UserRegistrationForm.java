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
    private String username;
    private String password;
    private String confirmPassword;
}
