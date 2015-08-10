package com.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: OrdemProcesso
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBOrdemProcesso")
public class OrdemProcesso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrdemProcessoPK id_ordem_processo;
	
	@ManyToOne
	@JoinColumn(name="id_atividade")
	private Atividade atividade;

	public OrdemProcesso() {
		super();
	}

	public OrdemProcessoPK getId_ordem_processo() {
		return id_ordem_processo;
	}

	public void setId_ordem_processo(OrdemProcessoPK id_ordem_processo) {
		this.id_ordem_processo = id_ordem_processo;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	} 
	
}
