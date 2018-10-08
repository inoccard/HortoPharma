package com.farma.bean;

/**
 * Classe contendo os dados do Farmaceutico
 *
 * @author Inocencio
 */

public class Farmaceutico {
	public int codigo;
	private String login;
	private String senha;
	private String cargo;
	private int nivel;
	
	public int getCodigo() {
		return codigo;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
		
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
