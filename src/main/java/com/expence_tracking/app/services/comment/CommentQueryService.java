package com.expence_tracking.app.services.comment;

import com.expence_tracking.app.repostiories.CommentRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentQueryService implements GraphQLQueryResolver
{
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
}
