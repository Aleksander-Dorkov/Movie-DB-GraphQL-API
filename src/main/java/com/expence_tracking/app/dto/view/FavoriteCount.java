package com.expence_tracking.app.dto.view;

import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteCount
{
    private Long count;
    private FavoriteType favoriteType;
}
