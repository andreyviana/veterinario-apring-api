package com.clinica.veterinaria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "veterinarios")
public class VeterinarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 50) @NotBlank(message = "Não pode estar vazio")
	private String nomeVeterinario;

	@Size(max = 50) @NotBlank(message = "Não pode estar vazio")
	private String especializacao;

	@OneToMany(mappedBy = "veterinario")
	private List<AnimalModel> animais;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVeterinario() {
		return this.nomeVeterinario;
	}

	public void setNomeVeterinario(String nome) {
		this.nomeVeterinario = nome;
	}

	public String getEspecializacao() {
		return this.especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
};
