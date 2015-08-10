package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SecaoAtendimento
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBSecaoAtendimento")
public class SecaoAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_secao;
	
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_unidade")
	private UnidadeAtendimento unidadeAtendimento;

	public SecaoAtendimento() {
		super();
	}   
	
	public long getId_secao() {
		return this.id_secao;
	}

	public void setId_secao(long id_secao) {
		this.id_secao = id_secao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public UnidadeAtendimento getUnidadeAtendimento() {
		return unidadeAtendimento;
	}
	
	public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
		this.unidadeAtendimento = unidadeAtendimento;
	}
	
}
