package com.expence_tracking.app.dto.binding.favorites;

import com.expence_tracking.app.domain.enums.FavoriteType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteCreate {

    @NotNull
    private Long userId;
    @NotNull
    private FavoriteType favoriteType;
    @NotNull
    private Long movieDBId;
}
