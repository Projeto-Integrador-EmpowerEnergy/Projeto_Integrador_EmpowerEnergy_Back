package com.empowerenergy.empowerenergy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_tema")
public class TemaModel {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema; 
	
	private @Enumerated(EnumType.STRING) Tema categoria;
	
    //private List<TemaModel> meusTemas = new ArrayList<>();
	
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

	/* public List<TemaModel> getMeusTemas() {
		return meusTemas;
	}

	public void setMeusTemas(List<TemaModel> meusTemas) {
		this.meusTemas = meusTemas;
	}
*/

	
	
}
