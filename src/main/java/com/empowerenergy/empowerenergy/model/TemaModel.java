package com.empowerenergy.empowerenergy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema; 
	
	private @Enumerated(EnumType.STRING) Tema categoria;
	
	private @NotBlank String solarTema;
		
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<TemaModel> tema = new ArrayList<>();

	public List<TemaModel> getTema() {
		return tema;
	}

	public void setTema(List<TemaModel> tema) {
		this.tema = tema;
	}

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public Tema getCategoria() {
		return categoria;
	}

	public void setCategoria(Tema categoria) {
		this.categoria = categoria;
	}


	}

