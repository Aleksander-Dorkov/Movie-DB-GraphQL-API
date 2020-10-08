package com.expence_tracking.app.services.iterfaces.favorites;

import com.expence_tracking.app.dto.binding.favorites.FavoriteCreate;
import com.expence_tracking.app.dto.binding.favorites.FavoriteDelete;
import com.expence_tracking.app.dto.view.FavoriteView;
import com.expence_tracking.app.dto.view.Message;
import graphql.kickstart.tools.GraphQLMutationResolver;

import javax.validation.Valid;

public interface FavoritesMutationServiceI extends GraphQLMutationResolver
{
    FavoriteView createFavorite(@Valid FavoriteCreate form);

    Message deleteFavorite(@Valid FavoriteDelete form);
}
