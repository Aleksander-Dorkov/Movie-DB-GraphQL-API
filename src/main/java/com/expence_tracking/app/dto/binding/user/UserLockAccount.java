package com.expence_tracking.app.dto.binding.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLockAccount
{
    private Long userId;
    private String password;
}
