package com.expence_tracking.app.dto.binding.user;

import com.expence_tracking.app.dto.binding.user.confirm_password_validation.ValidateConfirmPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ValidateConfirmPassword
public class UserCreate {

    private String username;
    private String password;
    private String confirmPassword;
    private Long authorityId;
}
