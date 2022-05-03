package br.com.conexinternet.combustivelapp.domain;

import java.io.Serializable;
import java.util.Objects;

public class Regiao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double precoPorCincoKm;
	
	public Regiao(){
	}

	public Regiao(Integer id, String nome, Double precoPorCincoKm) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoPorCincoKm = precoPorCincoKm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoPorCincoKm() {
		return precoPorCincoKm;
	}

	public void setPrecoPorCincoKm(Double precoPorCincoKm) {
		this.precoPorCincoKm = precoPorCincoKm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regiao other = (Regiao) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
