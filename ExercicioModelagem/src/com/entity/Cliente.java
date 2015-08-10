package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBClientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_cliente;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;

	public Cliente() {
		super();
	}   
	public long getId_cliente() {
		return this.id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
   
}
