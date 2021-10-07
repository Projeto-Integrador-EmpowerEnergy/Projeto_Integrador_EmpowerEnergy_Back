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

import com.empowerenergy.empowerenergy.model.PostagemModel;
import com.empowerenergy.empowerenergy.repository.PostagemRepository;


@RestController
@RequestMapping("/api/v1/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<PostagemModel>> getAll(){
		if(repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}
		
	@GetMapping("/{id_postagem}")	
	 public ResponseEntity<PostagemModel> getById(@PathVariable(value = "id_postagem") Long idPostagem) {
	        return repositorio.findById(idPostagem).map(resp -> ResponseEntity.status(200).body(resp))
	                .orElse(ResponseEntity.status(400).build());
	    }
	
	// ###################### NÃO APAGAR POR ENQUANTO (07.10.2021)#######################################
	
	/* @GetMapping("/{titulo}")
	public ResponseEntity<PostagemModel> getByTitulo(@PathVariable(value = "titulo") String titulo) {
		return ResponseEntity<PostagemModel>repositorio.findAllByTituloContainingIgnoreCase(titulo)
				.map(resp -> ResponseEntity.status(200).body(resp)
				.orElse(ResponseEntity.status(400).build());
	}*/
		
	@PostMapping("/salvar")
	public ResponseEntity<PostagemModel> salvar(@Valid @RequestBody PostagemModel novaPostagem){
		return ResponseEntity.status(201).body(repositorio.save(novaPostagem));
		
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<PostagemModel> atualizar(@Valid @RequestBody PostagemModel novoPostagem) {
		return ResponseEntity.status(201).body(repositorio.save(novoPostagem));
	}

	@DeleteMapping("/deletar/{id_postagem}")
	public ResponseEntity<PostagemModel> deletar(@PathVariable(value = "id_postagem") Long idPostagem) {
		Optional<PostagemModel> objetoOptional = repositorio.findById(idPostagem);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idPostagem);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
