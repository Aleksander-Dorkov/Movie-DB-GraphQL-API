package com.expence_tracking.app.services.comment;

import com.expence_tracking.app.domain.enums.FavoriteType;
import com.expence_tracking.app.dto.view.CommentView;
import com.expence_tracking.app.repostiories.CommentRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentQueryService implements GraphQLQueryResolver
{
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public List<CommentView> allCommentsByMovieDBIdAndFavoriteType(Long movieDBId, FavoriteType favoriteType)
    {
        return this.commentRepository.findAllByMovieDBIdAndFavoriteType(movieDBId, favoriteType).stream()
                .map(c ->
                {
                    CommentView map = this.modelMapper.map(c, CommentView.class);
                    map.setSubmitterId(c.getSubmitter().getUserId());
                    return map;
                }).collect(Collectors.toList());
    }
}
