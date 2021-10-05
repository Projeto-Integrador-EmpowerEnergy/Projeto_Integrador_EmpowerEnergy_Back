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

import com.empowerenergy.empowerenergy.model.Tema;
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
		} else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}
  
	@GetMapping("/{id_categoria}")
	public ResponseEntity<TemaModel> pegarPorId(@PathVariable(value = "id_categoria") Long idCategoria) {
		java.util.Optional<TemaModel> objetoOptional = repositorio.findById(idCategoria);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	
	/* @GetMapping("/GetTema")
	public Optional<Object> GetByTema(TemaModel temaParaPesquisar){
		return repositorio.findAllByTemaContainingIgnoreCase(temaParaPesquisar.getMeusTemas())
				.map(temaExistente -> ResponseEntity.status(201).body(temaExistente))
				.orElse(ResponseEntity.status(400).build());
												
	}
	*/
	@GetMapping("/GetTema")
	public ResponseEntity<List<TemaModel>> GetByTema(@PathVariable Tema categoria){
		return ResponseEntity.status(200).body(repositorio.findAllByCategoria(categoria));
												
	}
  
    @PostMapping("/salvar")
    public ResponseEntity<TemaModel> salvar(@Valid @RequestBody TemaModel novoTema) {
        return ResponseEntity.status(201).body(repositorio.save(novoTema));

    }
    
    @PutMapping("/atualizar")
	public ResponseEntity<TemaModel> atualizar(@Valid @RequestBody TemaModel novoTema) {
		return ResponseEntity.status(201).body(repositorio.save(novoTema));
	}
    
    @DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<TemaModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<TemaModel> objetoOptional = repositorio.findById(idUsuario);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
	


