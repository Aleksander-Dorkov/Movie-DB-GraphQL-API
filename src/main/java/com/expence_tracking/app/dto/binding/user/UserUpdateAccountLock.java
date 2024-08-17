package com.expence_tracking.app.dto.binding.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateAccountLock {

    @NotNull
    private Long userId;
    private String password;
}
