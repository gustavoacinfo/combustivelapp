package br.com.conexinternet.combustivelapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conexinternet.combustivelapp.domain.Quilometragem;
import br.com.conexinternet.combustivelapp.repositories.QuilometragemRepository;
import br.com.conexinternet.combustivelapp.services.exceptions.ObjectNotFoundException;

@Service
public class QuilometragemService {
	
	@Autowired
	private QuilometragemRepository repo;
	
	public Quilometragem buscar(Integer id) {
		Optional<Quilometragem> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Quilometragem.class.getName()));
	}

}
