package br.com.conexinternet.combustivelapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conexinternet.combustivelapp.domain.MesReferente;
import br.com.conexinternet.combustivelapp.repositories.MesReferenteRepository;
import br.com.conexinternet.combustivelapp.services.exceptions.ObjectNotFoundException;

@Service
public class MesReferenteService {
	
	@Autowired
	private MesReferenteRepository repo;
	
	public MesReferente buscar(Integer id) {
		Optional<MesReferente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + MesReferente.class.getName()));
	}

}
