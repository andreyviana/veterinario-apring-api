package com.clinica.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.veterinaria.model.VeterinarioModel;
import com.clinica.veterinaria.service.VeterinarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clinica")
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService veterinarioService;

	@GetMapping("/veterinarios")
	public ResponseEntity<List<VeterinarioModel>> getVeterinarios() {
		List<VeterinarioModel> veterinarios = this.veterinarioService.getVeterinarios();
		
		return !veterinarios.isEmpty()
			? ResponseEntity.ok(veterinarios) 
			: ResponseEntity.noContent().build();
	}

	@GetMapping("/veterinarios/{id}")
	public ResponseEntity<VeterinarioModel> getVeterinarioById(@PathVariable("id") Integer id) {
		Optional<VeterinarioModel> veterinario = this.veterinarioService.getVeterinarioById(id);

		return veterinario.isPresent() 
			? ResponseEntity.ok(veterinario.get()) 
			: ResponseEntity.notFound().build();
	}

	@PostMapping("/veterinarios")
	public ResponseEntity<VeterinarioModel> adicionarVeterinario(@RequestBody VeterinarioModel veterinario) {
		return ResponseEntity.status(201).body(this.veterinarioService.adicionarVeterinario(veterinario));
	}

	@PutMapping("/veterinarios/{id}")
	public ResponseEntity<Optional<VeterinarioModel>> atualizarVeterinario(@PathVariable("id") Integer id,@Valid @RequestBody VeterinarioModel veterinario) {
		return this.veterinarioService.atualizarVeterinario(id, veterinario).isPresent() 
			? ResponseEntity.ok(this.veterinarioService.atualizarVeterinario(id, veterinario)) 
			: ResponseEntity.notFound().build();
	}

	@DeleteMapping("/veterinarios/{id}")
	public ResponseEntity<Object> deletarVeterinario(@PathVariable("id") Integer id) {
		return this.veterinarioService.deletarVeterinario(id)
			? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
			: ResponseEntity.notFound().build();
 	}

}
