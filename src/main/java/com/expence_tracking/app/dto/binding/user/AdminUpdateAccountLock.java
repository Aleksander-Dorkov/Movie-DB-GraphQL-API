package com.expence_tracking.app.dto.binding.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AdminUpdateAccountLock
{
    @NotNull
    private Long userId;
    @NotNull
    private Boolean accountNonLocked;
}
