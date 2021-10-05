package com.empowerenergy.empowerenergy.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe espelho da tabela postagem no banco db_empowerenergy.
 * 
 * @author Lucas
 * @since 1.0
 *
 */

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long IdPostagem;
	private @NotBlank String titulo;
	private @NotBlank String descricao;
	private String imagem;
	private String localizacao;
	private String mencao;
	private String hashtag;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPostagem = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;

	@ManyToOne
	@JoinColumn(name = "id_tema")
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

	public Long getIdPostagem() {
		return IdPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		IdPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getMencao() {
		return mencao;
	}

	public void setMencao(String mencao) {
		this.mencao = mencao;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
}
