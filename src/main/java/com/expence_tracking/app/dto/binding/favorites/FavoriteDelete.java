package com.expence_tracking.app.dto.binding.favorites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteDelete
{
    @NotNull
    private Long favoriteId;
}
