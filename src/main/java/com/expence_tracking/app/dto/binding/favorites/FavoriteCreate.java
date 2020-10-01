package com.expence_tracking.app.dto.binding.favorites;

import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteCreate
{
    private Long userId;
    private FavoriteType favoriteType;
    private Long movieDBId;
}
