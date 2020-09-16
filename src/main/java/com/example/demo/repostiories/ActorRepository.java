package com.example.demo.repostiories;

import com.example.demo.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>
{
    Actor findByActorId(Long id);
}
