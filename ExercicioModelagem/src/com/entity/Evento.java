package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Evento
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBEvento")
public class Evento implements Serializable {
	   
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id_evento;
	
	@ManyToOne
	@JoinColumn(name="id_atendimento")
	private Atendimento atendimento;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario_execucao;
	
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TipoEvento tipoEvento;
	
	public Evento() {
		super();
	}
	
	public long getId_evento() {
		return this.id_evento;
	}

	public void setId_evento(long id_evento) {
		this.id_evento = id_evento;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public Date getHorario_execucao() {
		return horario_execucao;
	}
	
	public void setHorario_execucao(Date horario_execucao) {
		this.horario_execucao = horario_execucao;
	}
	
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
}
