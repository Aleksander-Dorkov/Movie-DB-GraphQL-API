package com.expence_tracking.app.services.comment;

import com.expence_tracking.app.repostiories.CommentRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentMutationService implements GraphQLMutationResolver
{
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
}
