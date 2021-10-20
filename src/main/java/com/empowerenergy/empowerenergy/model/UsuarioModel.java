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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private long idUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String nomeUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String sobrenomeUsuario;
	
	@ApiModelProperty(example = "email@email.com.br")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@NotBlank(message = "O atributo Usuário é Obrigatório!")
	@Size(min = 5, max = 50)
	private String emailUsuario;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String senhaUsuario;

	private int idadeUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	@ApiModelProperty(hidden = true)
	private List<PostagemModel> minhasPostagens = new ArrayList<>();

	public List<PostagemModel> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<PostagemModel> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}

	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}
	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public int getIdadeUsuario() {
		return idadeUsuario;
	}
	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}
	
	
	
	
	
}

	
	
