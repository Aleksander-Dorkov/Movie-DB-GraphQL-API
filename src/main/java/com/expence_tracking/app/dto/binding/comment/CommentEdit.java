package com.expence_tracking.app.dto.binding.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CommentEdit
{
    @NotNull
    private Long commentId;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
