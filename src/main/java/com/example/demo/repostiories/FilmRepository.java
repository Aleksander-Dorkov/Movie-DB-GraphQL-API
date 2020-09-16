package com.example.demo.repostiories;

import com.example.demo.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>
{
    Film findByFilmId(Long id);
}
