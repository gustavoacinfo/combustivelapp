package br.com.conexinternet.combustivelapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.conexinternet.combustivelapp.domain.enums.EstadoPagamento;

@Entity
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private EstadoPagamento estado;
	private Date dataPagamento;
	
	@OneToOne
	@JoinColumn(name="mes_referente_id")
	private MesReferente mesReferente;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estado, Date dataPagamento, MesReferente mesReferente) {
		super();
		this.id = id;
		this.estado = estado;
		this.dataPagamento = dataPagamento;
		this.mesReferente = mesReferente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public MesReferente getMesReferente() {
		return mesReferente;
	}

	public void setMesReferente(MesReferente mesReferente) {
		this.mesReferente = mesReferente;
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
