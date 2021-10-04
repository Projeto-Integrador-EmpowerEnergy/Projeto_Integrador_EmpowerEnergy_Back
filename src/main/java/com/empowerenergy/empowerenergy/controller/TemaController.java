package com.empowerenergy.empowerenergy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
}
	


