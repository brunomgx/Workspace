package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: UnidadeAtendimento
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBUnidadeAtendimento")
public class UnidadeAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_unidade;
	
	@Column
	private String nome;
	
	@Column
	private long latitude;
	
	@Column
	private long longitude;
	
	@OneToMany
	@JoinColumn(name="id_unidade")
	private List<SecaoAtendimento> secaoAtendimentoList;

	public UnidadeAtendimento() {
		super();
	}
	
	public long getId_unidade() {
		return this.id_unidade;
	}

	public void setId_unidade(long id_unidade) {
		this.id_unidade = id_unidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getLatitude() {
		return latitude;
	}
	
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
	public long getLongitude() {
		return longitude;
	}
	
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public List<SecaoAtendimento> getSecaoAtendimentoList() {
		return secaoAtendimentoList;
	}

	public void setSecaoAtendimentoList(List<SecaoAtendimento> secaoAtendimentoList) {
		this.secaoAtendimentoList = secaoAtendimentoList;
	}
	
}
