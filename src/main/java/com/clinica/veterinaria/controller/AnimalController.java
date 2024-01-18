package com.clinica.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.veterinaria.model.AnimalModel;
import com.clinica.veterinaria.service.AnimalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clinica")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@GetMapping("/animais")
	public ResponseEntity<List<AnimalModel>> getAnimais() {
		List<AnimalModel> animais = this.animalService.getAnimais();
		return !animais.isEmpty() ? ResponseEntity.ok(animais) : ResponseEntity.noContent().build();
	}

	@GetMapping("/animais/{id}")
	public ResponseEntity<Optional<AnimalModel>> getAnimalById(@PathVariable("id") Integer id) {
		Optional<AnimalModel> animal = this.animalService.getAnimalById(id);
		return animal.isPresent() ? ResponseEntity.ok(this.animalService.getAnimalById(id)) : ResponseEntity.notFound().build();
	}

	@PostMapping("/animais")
	public ResponseEntity<AnimalModel> cadastrarAnimal(@RequestBody AnimalModel animal) {
		return ResponseEntity.status(201).body(this.animalService.criarAnimal(animal));
	}

	@PutMapping("/animais/{id}")
	public ResponseEntity<Optional<AnimalModel>> atualizarAnimal(@PathVariable("id") Integer id, @Valid @RequestBody AnimalModel animal) {
		return this.animalService.atualizarAnimal(id, animal).isPresent() 
				? ResponseEntity.ok(this.animalService.atualizarAnimal(id, animal))
				: ResponseEntity.notFound().build();
	}

	@DeleteMapping("/animais/{id}")
	public ResponseEntity<Object> deletarAnimal(@PathVariable("id") Integer id) {
		return this.animalService.deletarAnimal(id)
			? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
	}
}
