package br.com.conexinternet.combustivelapp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.conexinternet.combustivelapp.domain.MesReferente;
import br.com.conexinternet.combustivelapp.domain.Pagamento;
import br.com.conexinternet.combustivelapp.domain.Quilometragem;
import br.com.conexinternet.combustivelapp.domain.Regiao;
import br.com.conexinternet.combustivelapp.domain.Tecnico;
import br.com.conexinternet.combustivelapp.domain.enums.EstadoPagamento;
import br.com.conexinternet.combustivelapp.repositories.MesReferenteRepository;
import br.com.conexinternet.combustivelapp.repositories.PagamentoRepository;
import br.com.conexinternet.combustivelapp.repositories.QuilometragemRepository;
import br.com.conexinternet.combustivelapp.repositories.RegiaoRepository;
import br.com.conexinternet.combustivelapp.repositories.TecnicoRepository;

@SpringBootApplication
public class CombustivelappApplication implements CommandLineRunner {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private MesReferenteRepository mesReferenteRepository;
	
	@Autowired
	private QuilometragemRepository quilometragemRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CombustivelappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Regiao reg1 = new Regiao(null, "UNAI", 5.00);
		Regiao reg2 = new Regiao(null, "INTERIOR", 4.30);
		
		regiaoRepository.saveAll(Arrays.asList(reg1, reg2)); 
		
		Tecnico tec1 = new Tecnico(null, "Gustavo", "gustavo@conex", "Net#4321");
		Tecnico tec2 = new Tecnico(null, "Rafael", "rafael@conex", "Net#1020");
		Tecnico tec3 = new Tecnico(null, "Eduardo", "eduardo@conex", "Net#5555");
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3));
		
		MesReferente mes1 = new MesReferente(null, "MAIO/2022", 550.00, tec1);
		MesReferente mes2 = new MesReferente(null, "MAIO/2022", 610.00, tec2);
		MesReferente mes3 = new MesReferente(null, "MAIO/2022", 730.00, tec3);
		
		mesReferenteRepository.saveAll(Arrays.asList(mes1,mes2,mes3));
		
		Quilometragem qui1 = new Quilometragem(null, 30, LocalDate.of(2022, 05, 04), 30/5 * reg1.getPrecoPorCincoKm(), reg1, mes1);
		Quilometragem qui2 = new Quilometragem(null, 40, LocalDate.of(2022, 05, 04), 40/5 * reg1.getPrecoPorCincoKm(), reg1, mes2);
		Quilometragem qui3 = new Quilometragem(null, 50, LocalDate.of(2022, 05, 05), 50/5 * reg1.getPrecoPorCincoKm(), reg1, mes1);
		Quilometragem qui4 = new Quilometragem(null, 35, LocalDate.of(2022, 05, 05), 35/5 * reg1.getPrecoPorCincoKm(), reg1, mes2);
		Quilometragem qui5 = new Quilometragem(null, 40, LocalDate.of(2022, 05, 04), 40/5 * reg2.getPrecoPorCincoKm(), reg2, mes3);
		Quilometragem qui6 = new Quilometragem(null, 45, LocalDate.of(2022, 05, 04), 45/5 * reg2.getPrecoPorCincoKm(), reg2, mes3);
		
		mes1.getQuilometragens().addAll(Arrays.asList(qui1,qui3));
		mes2.getQuilometragens().addAll(Arrays.asList(qui2,qui4));
		mes3.getQuilometragens().addAll(Arrays.asList(qui5,qui6));
		
		quilometragemRepository.saveAll(Arrays.asList(qui1,qui2,qui3,qui4,qui5,qui6));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pagamento pagto1 = new Pagamento(null, EstadoPagamento.QUITADO, sdf.parse("20/05/2022 17:00"), mes1);
		mes1.setPagamento(pagto1);
		
		Pagamento pagto2 = new Pagamento(null, EstadoPagamento.QUITADO, sdf.parse("20/05/2022 17:00"), mes2);
		mes2.setPagamento(pagto2);
		
		Pagamento pagto3 = new Pagamento(null, EstadoPagamento.QUITADO, sdf.parse("20/05/2022 17:00"), mes3);
		mes3.setPagamento(pagto3);
		
		tec1.getMesReferentes().addAll(Arrays.asList(mes1));
		
		tec2.getMesReferentes().addAll(Arrays.asList(mes2));
		
		//pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2,pagto3));
	}

}
