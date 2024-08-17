package com.expence_tracking.app.services.iterfaces.comment;

import com.expence_tracking.app.domain.enums.FavoriteType;
import com.expence_tracking.app.dto.view.comment.CommentView;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface CommentQueryService {

    @QueryMapping
    List<CommentView> allCommentsByMovieDBIdAndFavoriteType(Long movieDBId, FavoriteType favoriteType);
}
