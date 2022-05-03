package br.com.conexinternet.combustivelapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.conexinternet.combustivelapp.domain.Regiao;
import br.com.conexinternet.combustivelapp.repositories.RegiaoRepository;

@SpringBootApplication
public class CombustivelappApplication implements CommandLineRunner {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CombustivelappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Regiao reg1 = new Regiao(null, "UNAI", 5.00);
		Regiao reg2 = new Regiao(null, "INTERIOR", 4.30);
		
		regiaoRepository.saveAll(Arrays.asList(reg1, reg2)); 
		
	}

}
