package com.expence_tracking.app.services.iterfaces.comment;

import com.expence_tracking.app.domain.enums.FavoriteType;
import com.expence_tracking.app.dto.view.comment.CommentView;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface CommentQueryService extends GraphQLQueryResolver
{
    List<CommentView> allCommentsByMovieDBIdAndFavoriteType(Long movieDBId, FavoriteType favoriteType);
}
