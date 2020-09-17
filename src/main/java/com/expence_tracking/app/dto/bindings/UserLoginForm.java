package com.expence_tracking.app.dto.bindings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginForm
{
    private String username;
    private String password;
    private Boolean rememberMe;
}
