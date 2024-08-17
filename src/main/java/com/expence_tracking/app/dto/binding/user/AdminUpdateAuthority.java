package com.expence_tracking.app.dto.binding.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminUpdateAuthority {

    @NotNull
    private Long userId;
    @NotNull
    private Long authorityId;
}
