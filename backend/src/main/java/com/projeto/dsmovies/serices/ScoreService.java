package com.projeto.dsmovies.serices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dsmovies.dto.MovieDTO;
import com.projeto.dsmovies.dto.ScoreDTO;
import com.projeto.dsmovies.entities.Movie;
import com.projeto.dsmovies.entities.Score;
import com.projeto.dsmovies.entities.User;
import com.projeto.dsmovies.repositories.MovieRepository;
import com.projeto.dsmovies.repositories.ScoreRepository;
import com.projeto.dsmovies.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		Double sum = 0.0;
		for(Score s :movie.getScores()) {
			sum = sum + s.getValue();			
		}
		
		Double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
}
