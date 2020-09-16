package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Film
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;
    private String name;
    private Date launchYear;
}
