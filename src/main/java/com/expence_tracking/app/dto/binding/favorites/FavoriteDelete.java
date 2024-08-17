package com.expence_tracking.app.dto.binding.favorites;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteDelete {

    @NotNull
    private Long favoriteId;
}
