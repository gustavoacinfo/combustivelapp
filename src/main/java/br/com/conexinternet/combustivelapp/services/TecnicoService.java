package br.com.conexinternet.combustivelapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.conexinternet.combustivelapp.domain.Tecnico;
import br.com.conexinternet.combustivelapp.repositories.TecnicoRepository;
import br.com.conexinternet.combustivelapp.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repo;
	
	public Tecnico buscar(Integer id) {
		Optional<Tecnico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

}
