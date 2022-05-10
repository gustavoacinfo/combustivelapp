package br.com.conexinternet.combustivelapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Quilometragem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer quilometros;
	private LocalDate data;
	private Double valorCalculado;
	private boolean aprovado;
	private boolean pago;
	
	@ManyToOne
	@JoinColumn(name="regiao_id")
	private Regiao regiao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="tecnico_id")
	private Tecnico tecnico;
	
	public Quilometragem() {
		
	}

	

	public Quilometragem(Integer id, Integer quilometros, LocalDate data, Double valorCalculado,
			boolean aprovado, boolean pago, Regiao regiao, Tecnico tecnico) {
		super();
		this.id = id;
		this.quilometros = quilometros;
		this.data = data;
		this.valorCalculado = valorCalculado;
		this.aprovado = aprovado;
		this.pago = pago;
		this.regiao = regiao;
		this.tecnico = tecnico;
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
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
