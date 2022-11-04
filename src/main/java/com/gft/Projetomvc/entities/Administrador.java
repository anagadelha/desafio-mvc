package com.gft.Projetomvc.entities;

import javax.persistence.*;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "usuario", length = 100, nullable = false)
	private String usuario;

	@Column(name = "senha", length = 100, nullable = false)
	private String senha;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "quatro_letras", length = 4, nullable = false)
	private String quatroLetras;
	
	@Column(name = "roles")
	private final String role = "ADMIN";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuatroLetras() {
		return quatroLetras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatroLetras = quatroLetras;
	}

	public String getRole() {
		return role;
	}
	

}
