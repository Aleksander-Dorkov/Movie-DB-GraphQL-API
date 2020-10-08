package com.expence_tracking.app.services.implementations.comment;

import com.expence_tracking.app.domain.enums.FavoriteType;
import com.expence_tracking.app.dto.view.comment.CommentView;
import com.expence_tracking.app.dto.view.comment.Submitter;
import com.expence_tracking.app.repostiories.CommentRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.comment.CommentQueryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService
{
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CommentView> allCommentsByMovieDBIdAndFavoriteType(Long movieDBId, FavoriteType favoriteType)
    {
        return this.commentRepository.findAllByMovieDBIdAndFavoriteType(movieDBId, favoriteType).stream()
                .map(c ->
                {
                    CommentView comment = this.modelMapper.map(c, CommentView.class);
                    Submitter submitter = this.modelMapper.map(c.getSubmitter(), Submitter.class);
                    comment.setSubmitter(submitter);
                    return comment;
                })
                .sorted((o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate()))
                .collect(Collectors.toList());
    }
}
