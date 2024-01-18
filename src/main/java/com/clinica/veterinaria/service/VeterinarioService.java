package com.clinica.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.veterinaria.model.VeterinarioModel;
import com.clinica.veterinaria.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	public List<VeterinarioModel> getVeterinarios() {
		List<VeterinarioModel> veterinarios = this.veterinarioRepository.findAll();
		return veterinarios;
	}

	public Optional<VeterinarioModel> getVeterinarioById(Integer id) {
		return this.veterinarioRepository.findById(id);
	}
	
	public VeterinarioModel adicionarVeterinario(VeterinarioModel veterinario) {
		return this.veterinarioRepository.save(veterinario);
	}
	
	public Optional<VeterinarioModel> atualizarVeterinario(Integer id, VeterinarioModel veterinario) {
		return this.veterinarioRepository.findById(id).map(x -> {
			x.setNomeVeterinario(veterinario.getNomeVeterinario());
			x.setEspecializacao(veterinario.getEspecializacao());
			return this.veterinarioRepository.save(x);
		});
	}
	
	public Boolean deletarVeterinario(Integer id) {
		return getVeterinarioById(id).map(x -> {
			this.veterinarioRepository.delete(x);
			return true;
		}).orElse(false);
	}
}
