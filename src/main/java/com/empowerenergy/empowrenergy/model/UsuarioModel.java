package com.empowerenergy.empowrenergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String nomeUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String sobrenomeUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String emailUsuario;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String senhaUsuario;
	
	@NotBlank
	private int idadeUsuario;
	
	
	@OneToMany
	//@JsonIgnoreProperties()
	//private
	
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
