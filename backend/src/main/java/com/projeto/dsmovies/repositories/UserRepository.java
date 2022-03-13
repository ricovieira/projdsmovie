package com.projeto.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dsmovies.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
