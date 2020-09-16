package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Actor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    private String firstName;
    private String lastName;
    private String address;
    private Date dob;
    @ManyToMany
    @JoinTable(
            name = "actors_films",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actorId"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "filmId"))
    private Set<Film> actorsFilms;

}
