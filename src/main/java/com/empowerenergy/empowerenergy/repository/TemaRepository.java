package com.empowerenergy.empowerenergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empowerenergy.empowerenergy.model.Tema;
import com.empowerenergy.empowerenergy.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	public List<TemaModel> findAllByCategoria(Tema categoria);

}