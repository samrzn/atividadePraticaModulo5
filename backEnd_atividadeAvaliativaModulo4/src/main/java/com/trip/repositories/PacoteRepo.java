package com.trip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trip.model.entity.Pacote;

@Repository
public interface PacoteRepo extends JpaRepository<Pacote, Integer> {

	boolean existsById(Integer id_pacote);

}
