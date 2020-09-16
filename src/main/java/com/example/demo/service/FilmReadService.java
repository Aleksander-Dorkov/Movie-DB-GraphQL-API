package com.example.demo.service;

import com.example.demo.domain.Film;
import com.example.demo.repostiories.FilmRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmReadService implements GraphQLQueryResolver
{
    private final FilmRepository filmRepository;

    public Film getFilmById(Long id)
    {
        return this.filmRepository.findByFilmId(id);
    }

    public List<Film> getAllFilms()
    {
        return this.filmRepository.findAll();
    }
}
