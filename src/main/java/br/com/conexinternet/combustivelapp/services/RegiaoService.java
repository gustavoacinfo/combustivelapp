package br.com.conexinternet.combustivelapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conexinternet.combustivelapp.domain.Regiao;
import br.com.conexinternet.combustivelapp.repositories.RegiaoRepository;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repo;
	
	public Regiao buscar(Integer id) {
		Optional<Regiao> obj = repo.findById(id);
		return obj.orElse(null); 
	}

}
