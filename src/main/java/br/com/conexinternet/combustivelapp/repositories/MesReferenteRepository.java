package br.com.conexinternet.combustivelapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conexinternet.combustivelapp.domain.MesReferente;

@Repository
public interface MesReferenteRepository extends JpaRepository<MesReferente, Integer>{
	
}
