package com.empowerenergy.empowerenergy.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empowerenergy.empowerenergy.model.UsuarioModel;
import com.empowerenergy.empowerenergy.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioModel>> getAll(){
		if(repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}
		
	@GetMapping("/{id_usuario}")	
	 public ResponseEntity<UsuarioModel> getById(@PathVariable(value = "id_usuario") Long idUsuario) {
	        return repositorio.findById(idUsuario).map(resp -> ResponseEntity.status(200).body(resp))
	                .orElse(ResponseEntity.status(400).build());
	    }
	
		
	@PostMapping("/salvar")
	public ResponseEntity<UsuarioModel> salvar(@Valid @RequestBody UsuarioModel novaUsuario){
		return ResponseEntity.status(201).body(repositorio.save(novaUsuario));
		
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> atualizar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<UsuarioModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModel> objetoOptional = repositorio.findById(idUsuario);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}