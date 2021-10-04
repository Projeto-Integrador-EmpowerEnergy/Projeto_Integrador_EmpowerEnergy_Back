package com.empowerenergy.empowerenergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empowerenergy.empowerenergy.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	
public List<TemaModel> findAllByTemaContainingIgnoreCase(String descricao);


}