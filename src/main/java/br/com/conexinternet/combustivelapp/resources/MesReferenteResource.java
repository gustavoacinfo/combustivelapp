package br.com.conexinternet.combustivelapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexinternet.combustivelapp.domain.MesReferente;
import br.com.conexinternet.combustivelapp.services.MesReferenteService;

@RestController
@RequestMapping(value="/mesreferentes")
public class MesReferenteResource {
	
	@Autowired
	private MesReferenteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		MesReferente obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
