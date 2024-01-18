package com.clinica.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.veterinaria.repository.AnimalRepository;
import com.clinica.veterinaria.model.AnimalModel;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRepository;

	public List<AnimalModel> getAnimais() {
		return this.animalRepository.findAll();
	}

	public Optional<AnimalModel> getAnimalById(Integer id) {
		return this.animalRepository.findById(id);
	}

	public AnimalModel criarAnimal(AnimalModel animal) {
		return this.animalRepository.save(animal);
	}

	public Optional<AnimalModel> atualizarAnimal(Integer id, AnimalModel animal) {
		return getAnimalById(id).map(x -> {
			x.setAnimal(animal.getAnimal());
			x.setNomeDono(animal.getNomeDono());
			x.setRecebeuAlta(animal.getRecebeuAlta());
			x.setDiagnostico(animal.getDiagnostico());
			x.setVeterinario(animal.getVeterinario());
			return this.animalRepository.save(x);
		});
	}

	public Boolean deletarAnimal(Integer id) {
		return getAnimalById(id).map(x -> {
			this.animalRepository.deleteById(id);
			return true;
		}).orElse(false);
	}
}
