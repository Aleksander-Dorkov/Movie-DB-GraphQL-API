package com.expence_tracking.app.services.iterfaces.favorites;

import com.expence_tracking.app.dto.view.FavoriteCount;
import com.expence_tracking.app.dto.view.FavoriteView;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface FavoriteQueryService {

    @QueryMapping
    List<FavoriteView> allFavoritesByUser(Long id);

    @QueryMapping
    List<FavoriteCount> countFavoriteByUser(Long id);
}
