package br.com.conexinternet.combustivelapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quilometragem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer quilometros;
	private LocalDate data;
	private Double valorCalculado;
	
	private Regiao regiao;
	
	public Quilometragem() {
		
	}

	public Quilometragem(Integer id, Integer quilometros, LocalDate data, Double valorCalculado) {
		super();
		this.id = id;
		this.quilometros = quilometros;
		this.data = data;
		this.valorCalculado = valorCalculado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuilometros() {
		return quilometros;
	}

	public void setQuilometros(Integer quilometros) {
		this.quilometros = quilometros;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
		Quilometragem other = (Quilometragem) obj;
		return Objects.equals(id, other.id);
	}
	
	

}