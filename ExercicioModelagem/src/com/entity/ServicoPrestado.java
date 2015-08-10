package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ServicoPrestado
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBServicoPrestado")
public class ServicoPrestado implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_servico_prestado;
	
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public ServicoPrestado() {
		super();
	}   
	public long getId_servico_prestado() {
		return this.id_servico_prestado;
	}

	public void setId_servico_prestado(long id_servico_prestado) {
		this.id_servico_prestado = id_servico_prestado;
	}
	
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
