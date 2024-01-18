package com.clinica.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.veterinaria.model.AnimalModel;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Integer>{
	
}
