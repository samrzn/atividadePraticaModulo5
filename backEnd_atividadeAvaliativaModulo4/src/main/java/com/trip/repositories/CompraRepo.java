package com.trip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trip.model.entity.Compra;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
	
}
