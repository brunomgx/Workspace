package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Atividade
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBAtividade")
public class Atividade implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_atividade;
	
	@Column
	private String descricao;

	public Atividade() {
		super();
	} 
	
	public long getId_atividade() {
		return this.id_atividade;
	}

	public void setId_atividade(long id_atividade) {
		this.id_atividade = id_atividade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
