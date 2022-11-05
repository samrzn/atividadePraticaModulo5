package com.trip.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trip.model.entity.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

	boolean existsByEmail(String email); 
	
	Optional<Cliente> findByEmail(String email);
	
}
