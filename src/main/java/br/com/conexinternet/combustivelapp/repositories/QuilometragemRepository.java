package br.com.conexinternet.combustivelapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conexinternet.combustivelapp.domain.Quilometragem;

@Repository
public interface QuilometragemRepository extends JpaRepository<Quilometragem, Integer>{
	
}
