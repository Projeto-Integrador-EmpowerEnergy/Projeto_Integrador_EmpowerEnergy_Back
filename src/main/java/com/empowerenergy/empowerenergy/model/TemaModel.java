package com.empowerenergy.empowerenergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema; 
	
	private @NotBlank String eolicaTema;
	
	private @NotBlank String hidricaTema;
	
	private @NotBlank String biomassaTema;
	
	private @NotBlank String solarTema;
	

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
