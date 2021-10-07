package com.empowerenergy.empowerenergy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empowerenergy.empowerenergy.model.UsuarioModel;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<UsuarioModel> findByNomeUsuario(String nomeUsuario);

}
