package br.com.conexinternet.combustivelapp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexinternet.combustivelapp.domain.Regiao;

@RestController
@RequestMapping(value="/regioes")
public class RegiaoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Regiao> listar() {
		
		Regiao reg1 = new Regiao(1, "Unai", 5.0);
		Regiao reg2 = new Regiao(2, "Sobradinho", 4.3);
		
		List<Regiao> lista = new ArrayList<>();
		lista.add(reg1);
		lista.add(reg2);
		
		return lista;
	}

}
