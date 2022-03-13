package com.projeto.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dsmovies.entities.Score;
import com.projeto.dsmovies.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
