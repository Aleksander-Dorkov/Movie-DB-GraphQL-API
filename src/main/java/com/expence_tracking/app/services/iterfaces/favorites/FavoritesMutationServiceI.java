package com.expence_tracking.app.services.iterfaces.favorites;

import com.expence_tracking.app.dto.binding.favorites.FavoriteCreate;
import com.expence_tracking.app.dto.binding.favorites.FavoriteDelete;
import com.expence_tracking.app.dto.view.FavoriteView;
import com.expence_tracking.app.dto.view.Message;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public interface FavoritesMutationServiceI {

    @MutationMapping
    FavoriteView createFavorite(@Argument("form") @Valid FavoriteCreate form);

    @MutationMapping
    Message deleteFavorite(@Argument("form") @Valid FavoriteDelete form);
}
