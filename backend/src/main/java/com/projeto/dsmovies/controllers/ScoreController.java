package com.projeto.dsmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.dsmovies.dto.MovieDTO;
import com.projeto.dsmovies.dto.ScoreDTO;
import com.projeto.dsmovies.serices.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO soveScore(@RequestBody ScoreDTO dto) {				
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
