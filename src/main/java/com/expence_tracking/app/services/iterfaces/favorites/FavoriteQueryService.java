package com.expence_tracking.app.services.iterfaces.favorites;

import com.expence_tracking.app.dto.view.FavoriteCount;
import com.expence_tracking.app.dto.view.FavoriteView;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface FavoriteQueryService extends GraphQLQueryResolver
{
    List<FavoriteView> allFavoritesByUser(Long id);

    List<FavoriteCount> countFavoriteByUser(Long id);
}
