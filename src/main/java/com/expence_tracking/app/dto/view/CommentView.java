package com.expence_tracking.app.dto.view;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentView
{
    private Long commentId;
    private Long movieDBId;
    private Long submitterId;
    private FavoriteType favoriteType;
    private String title;
    private String description;
    private LocalDateTime creationDate;
}
