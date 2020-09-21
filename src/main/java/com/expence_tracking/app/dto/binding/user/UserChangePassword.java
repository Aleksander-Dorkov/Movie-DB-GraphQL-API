package com.expence_tracking.app.dto.binding.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserChangePassword
{
    private Long userId;
    private String oldPassword;
    private String newPassword;
}
