package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * ID class for entity: OrdemProcesso
 * @author Bruno C. S. Feliciano
 */
@Embeddable
public class OrdemProcessoPK  implements Serializable {   
   
	private static final long serialVersionUID = 1L;
	         
	private Servico servico;
	
	private long ordem_atividade;

	public OrdemProcessoPK() {}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public long getOrdem_atividade() {
		return this.ordem_atividade;
	}

	public void setOrdem_atividade(long ordem_atividade) {
		this.ordem_atividade = ordem_atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (ordem_atividade ^ (ordem_atividade >>> 32));
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemProcessoPK other = (OrdemProcessoPK) obj;
		if (ordem_atividade != other.ordem_atividade)
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}

}
