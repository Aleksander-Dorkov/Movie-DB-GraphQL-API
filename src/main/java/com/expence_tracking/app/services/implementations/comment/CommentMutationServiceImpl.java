package com.expence_tracking.app.services.implementations.comment;

import com.expence_tracking.app.domain.Comment;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.binding.comment.CommentCreate;
import com.expence_tracking.app.dto.binding.comment.CommentEdit;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.dto.view.comment.CommentView;
import com.expence_tracking.app.dto.view.comment.Submitter;
import com.expence_tracking.app.repostiories.CommentRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.comment.CommentMutationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Service
@Validated
@AllArgsConstructor
public class CommentMutationServiceImpl implements CommentMutationService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    @PreAuthorize("isAuthenticated()")
    public CommentView createComment(@Valid CommentCreate form) {
        User submitter = userRepository.getOne(form.getUserId());
        Comment newComment = this.modelMapper.map(form, Comment.class);
        newComment.setCreationDate(LocalDateTime.now());
        newComment.setSubmitter(submitter);
        Long newCommentId = this.commentRepository.save(newComment).getCommentId();

        Comment savedComment = this.commentRepository.findByCommentId(newCommentId);
        CommentView commentVew = this.modelMapper.map(savedComment, CommentView.class);
        Submitter map = this.modelMapper.map(savedComment.getSubmitter(), Submitter.class);
        commentVew.setSubmitter(map);
        return commentVew;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Message deleteComment(@NotNull Long id) {
        this.commentRepository.deleteById(id);
        return new Message("Successfully deleted comment");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public CommentView updateComment(@Valid CommentEdit form) {
        Comment comment = this.commentRepository.findByCommentId(form.getCommentId());
        assert comment != null;
        comment.setTitle(form.getTitle());
        comment.setDescription(form.getDescription());
        this.commentRepository.save(comment);

        CommentView commentVew = this.modelMapper.map(comment, CommentView.class);
        Submitter submitter = this.modelMapper.map(comment.getSubmitter(), Submitter.class);
        commentVew.setSubmitter(submitter);
        return commentVew;
    }
}
