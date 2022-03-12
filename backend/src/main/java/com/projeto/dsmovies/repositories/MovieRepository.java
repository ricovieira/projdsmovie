package com.projeto.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dsmovies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
