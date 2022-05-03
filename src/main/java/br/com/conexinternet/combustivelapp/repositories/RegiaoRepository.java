package br.com.conexinternet.combustivelapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.conexinternet.combustivelapp.domain.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer>{
	
}
