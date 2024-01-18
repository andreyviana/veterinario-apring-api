package com.clinica.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clinica.veterinaria.model.VeterinarioModel;

@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioModel, Integer>{
	
}
