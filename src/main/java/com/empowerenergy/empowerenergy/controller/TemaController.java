package com.empowerenergy.empowerenergy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empowerenergy.empowerenergy.model.TemaModel;
import com.empowerenergy.empowerenergy.repository.TemaRepository;


@RestController
@RequestMapping("/api/v1/tema")
@CrossOrigin("*")
public class TemaController {



	@Autowired
	private TemaRepository repositorio;
	
	@GetMapping("/todas")
	public ResponseEntity<List<TemaModel>> GetAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();		
		}
		else{
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}
			
		@DeleteMapping("/deletar/{id_usuario}")
		public ResponseEntity<TemaModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
			Optional<TemaModel> objetoOptional = repositorio.findById(idUsuario);
			if (objetoOptional.isPresent()) {
				repositorio.deleteById(idUsuario);
				return ResponseEntity.status(204).build();
			}
			else {
				return ResponseEntity.status(400).build();
			}
			
				
	}
}


