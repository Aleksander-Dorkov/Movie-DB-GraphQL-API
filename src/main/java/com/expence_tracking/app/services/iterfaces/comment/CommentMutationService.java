package com.expence_tracking.app.services.iterfaces.comment;

import com.expence_tracking.app.dto.binding.comment.CommentCreate;
import com.expence_tracking.app.dto.binding.comment.CommentEdit;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.dto.view.comment.CommentView;
import graphql.kickstart.tools.GraphQLMutationResolver;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface CommentMutationService extends GraphQLMutationResolver
{
    CommentView createComment(@Valid CommentCreate form);

    Message deleteComment(@NotNull Long id);

    CommentView updateComment(@Valid CommentEdit form);
}
