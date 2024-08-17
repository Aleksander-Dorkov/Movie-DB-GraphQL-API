package com.expence_tracking.app.services.iterfaces.comment;

import com.expence_tracking.app.dto.binding.comment.CommentCreate;
import com.expence_tracking.app.dto.binding.comment.CommentEdit;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.dto.view.comment.CommentView;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public interface CommentMutationService {

    @MutationMapping
    CommentView createComment(@Argument("form") @Valid CommentCreate form);

    @MutationMapping
    Message deleteComment(@Argument("form") @NotNull Long id);

    @MutationMapping
    CommentView updateComment(@Argument("form") @Valid CommentEdit form);
}
