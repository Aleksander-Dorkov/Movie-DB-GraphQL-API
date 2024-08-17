package com.expence_tracking.app.dto.binding.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentEdit {

    @NotNull
    private Long commentId;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
