package com.expence_tracking.app.dto.view.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Submitter
{
    private Long userId;
    private String username;
    private LocalDateTime registrationDate;
    private Boolean accountNonLocked;
}
