package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Atendente
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBAtendentes")
public class Atendente implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_atendente;
	
	@Column
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Atendente() {
		super();
	}
	
	public long getId_atendente() {
		return this.id_atendente;
	}

	public void setId_atendente(long id_atendente) {
		this.id_atendente = id_atendente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
