package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoEvento
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBTipoEvento")
public class TipoEvento implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id_tipo;
	
	@Column
	private String descricao;

	public TipoEvento() {
		super();
	}
	
	public long getId_tipo() {
		return this.id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
   
}
