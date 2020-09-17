package com.expence_tracking.app.dto.bindings.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationForm
{
    private String username;
    private String password;
    private String confirmPassword;
}
