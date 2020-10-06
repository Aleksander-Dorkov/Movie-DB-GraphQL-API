package com.expence_tracking.app.dto.binding.comment;

import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreate
{
    @NotNull
    private Long movieDBId;
    @NotNull
    private Long userId;
    @NotNull
    private FavoriteType favoriteType;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
