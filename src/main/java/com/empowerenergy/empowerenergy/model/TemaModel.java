package com.empowerenergy.empowerenergy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	private @NotBlank String eolicaTema;
	
	private @NotBlank String hidricaTema;
	
	private @NotBlank String biomassaTema;
	
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

	public String getEolicaTema() {
		return eolicaTema;
	}

	public void setEolicaTema(String eolicaTema) {
		this.eolicaTema = eolicaTema;
	}

	public String getHidricaTema() {
		return hidricaTema;
	}

	public void setHidricaTema(String hidricaTema) {
		this.hidricaTema = hidricaTema;
	}

	public String getBiomassaTema() {
		return biomassaTema;
	}

	public void setBiomassaTema(String biomassaTema) {
		this.biomassaTema = biomassaTema;
	}

	public String getSolarTema() {
		return solarTema;
	}

	public void setSolarTema(String solarTema) {
		this.solarTema = solarTema;
	}
	
	
}
