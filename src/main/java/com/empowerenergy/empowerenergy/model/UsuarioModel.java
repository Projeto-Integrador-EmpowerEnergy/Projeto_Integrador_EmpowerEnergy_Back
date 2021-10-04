package com.empowerenergy.empowerenergy.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


=======
>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java
@Entity
@Table(name = "usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java
	private Long idUsuario;
=======
	private long idUsuario;
>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java

	@NotBlank
	@Size(min = 5, max = 100)
	private String nomeUsuario;

	@NotBlank
	@Size(min = 5, max = 100)
	private String sobrenomeUsuario;

<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java
	@NotBlank
	@Size(min = 5, max = 50)
=======
	private int idadeUsuario;

	@Email
>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java
	private String emailUsuario;

	@NotBlank
	@Size(min = 5, max = 100)
	private String senhaUsuario;

<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java
	@NotBlank
	private int idadeUsuario;

	@OneToMany
	@JsonIgnoreProperties
	// private

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
=======
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java
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

<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java
=======
	public int getIdadeUsuario() {
		return idadeUsuario;
	}

	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java
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
<<<<<<< HEAD:src/main/java/com/empowerenergy/empowrenergy/model/UsuarioModel.java

	public int getIdadeUsuario() {
		return idadeUsuario;
	}

	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

=======
>>>>>>> 601a8048d085d2906885e48c4f153db548272916:src/main/java/com/empowerenergy/empowerenergy/model/UsuarioModel.java
}
