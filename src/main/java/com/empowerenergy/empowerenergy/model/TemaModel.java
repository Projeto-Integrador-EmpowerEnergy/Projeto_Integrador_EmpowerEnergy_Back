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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@ApiModelProperty(hidden = true)
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema; 

	private @Enumerated(EnumType.STRING) Tema categoria;

		
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	@ApiModelProperty(hidden = true)
	private List<PostagemModel> postagens = new ArrayList<>();


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


	public List<PostagemModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagemModel> postagens) {
		this.postagens = postagens;
	}
}

