package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Servico
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBServico")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_servico;
	
	@Column
	private String descricao;

	public Servico() {
		super();
	}   
	public long getId_servico() {
		return this.id_servico;
	}

	public void setId_servico(long id_servico) {
		this.id_servico = id_servico;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
