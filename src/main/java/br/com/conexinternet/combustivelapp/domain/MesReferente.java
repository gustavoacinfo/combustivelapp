package br.com.conexinternet.combustivelapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MesReferente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String mesAno;
	private Double valorFinal;
	
	@ManyToOne
	@JoinColumn(name="tecnico_id")
	private Tecnico tecnico;
	
	@JsonManagedReference
	@OneToMany(mappedBy="mesReferente", cascade = CascadeType.ALL)
	private List<Quilometragem> quilometragens = new ArrayList<>();
	
	@JsonManagedReference
	@OneToOne(mappedBy="mesReferente")
	private Pagamento pagamento;
	
	public MesReferente() {
		
	}

	public MesReferente(Integer id, String mesAno, Double valorFinal, Tecnico tecnico) {
		super();
		this.id = id;
		this.mesAno = mesAno;
		this.valorFinal = valorFinal;
		this.tecnico = tecnico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Quilometragem> getQuilometragens() {
		return quilometragens;
	}

	public void setQuilometragens(List<Quilometragem> quilometragens) {
		this.quilometragens = quilometragens;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
		MesReferente other = (MesReferente) obj;
		return Objects.equals(id, other.id);
	}

}
