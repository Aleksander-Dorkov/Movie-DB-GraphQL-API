package com.example.demo.service;

import com.example.demo.domain.Actor;
import com.example.demo.repostiories.ActorRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorReadService implements GraphQLQueryResolver
{
    private final ActorRepository actorRepository;

    public Actor getActorById(Long id)
    {
        return this.actorRepository.findByActorId(id);
    }

    public List<Actor> getAllActors()
    {
        return this.actorRepository.findAll();
    }
}
