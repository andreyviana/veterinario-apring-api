package com.clinica.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "animais")
public class AnimalModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 3, max = 50) @NotNull
	private String animal;

	@Size(min = 3, max = 50) @NotNull
	private String nomeDono;

	@Column(name = "recebeu_alta") @NotNull
	private Boolean recebeuAlta;

	@Column(name = "diagnostico")
	private String diagnostico;
	
	@ManyToOne
	@JoinColumn(name = "id_veterinario", nullable = false) 
	private VeterinarioModel veterinario;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAnimal() {
		return this.animal;
	}
	
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	public String getNomeDono() {
		return this.nomeDono;
	}
	
	public void setNomeDono(String nome) {
		this.nomeDono = nome;
	}
	
	public Boolean getRecebeuAlta() {
		return this.recebeuAlta;
	}
	
	public void setRecebeuAlta(Boolean recebeuAlta) {
		this.recebeuAlta = recebeuAlta;
	}
	
	public String getDiagnostico() {
		return this.diagnostico;
	}
	
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public VeterinarioModel getVeterinario() {
		return this.veterinario;
	}
	
	public void setVeterinario(VeterinarioModel veterinario) {
		this.veterinario = veterinario;
		
	}
}
