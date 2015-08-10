package com.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Atendimento
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBAtendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_atendimento;
	
	@ManyToOne
	@JoinColumn(name="id_atividade")
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name="id_atendente")
	private Atendente atendente;
	
	@ManyToOne
	@JoinColumn(name="id_secao")
	private SecaoAtendimento secaoAtendimento;
	
	@ManyToOne
	@JoinColumn(name="id_servico_prestado")
	private ServicoPrestado servicoPrestado;

	public Atendimento() {
		super();
	}
	
	public long getId_atendimento() {
		return this.id_atendimento;
	}

	public void setId_atendimento(long id_atendimento) {
		this.id_atendimento = id_atendimento;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	public Atendente getAtendente() {
		return atendente;
	}
	
	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	
	public SecaoAtendimento getSecaoAtendimento() {
		return secaoAtendimento;
	}
	
	public void setSecaoAtendimento(SecaoAtendimento secaoAtendimento) {
		this.secaoAtendimento = secaoAtendimento;
	}
	
	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}
	
	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}
   
}
