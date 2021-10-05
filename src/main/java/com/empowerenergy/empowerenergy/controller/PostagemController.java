package com.empowerenergy.empowerenergy.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empowerenergy.empowerenergy.model.PostagemModel;
import com.empowerenergy.empowerenergy.repository.PostagemRepository;

@RestController
@RequestMapping("/api/v1/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositorio;
	
	@PutMapping("/atualizar")
	public ResponseEntity<PostagemModel> atualizar(@Valid @RequestBody PostagemModel novoPostagem) {
		return ResponseEntity.status(201).body(repositorio.save(novoPostagem));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<PostagemModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<PostagemModel> objetoOptional = repositorio.findById(idUsuario);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}
}
