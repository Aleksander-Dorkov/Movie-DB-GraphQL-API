package com.example.demo.service;

import com.example.demo.domain.Actor;
import com.example.demo.dto.ActorForm;
import com.example.demo.repostiories.ActorRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorWriteService implements GraphQLMutationResolver
{
    private final ActorRepository actorRepository;


    public Actor updateActorAddress(Long id, String address)
    {
        Actor actor = this.actorRepository.findByActorId(id);
        actor.setAddress(address);
        return this.actorRepository.save(actor);
    }

    public Actor updateActorForm(ActorForm form)
    {
        Actor actor = this.actorRepository.findByActorId(form.getActorId());
        actor.setAddress(form.getAddress());
        actor.setFirstName(form.getFirstName());
        actor.setLastName(form.getLastName());
        return this.actorRepository.save(actor);
    }
}
