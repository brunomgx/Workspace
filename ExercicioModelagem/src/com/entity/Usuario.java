package com.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 * @author Bruno C. S. Feliciano
 */
@Entity
@Table(name="TBUsuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private long id_usuario;
	
	@Column
	private String usuario;
	
	@Column
	private String senha;

	public Usuario() {
		super();
	}
	
	public long getId_usuario() {
		return this.id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
