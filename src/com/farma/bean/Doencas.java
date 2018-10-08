package com.farma.bean;

import com.farma.bean.enums.ClasseProduto;

/**
 * Classe contendo os dados de doenças
 *
 * @author Inocencio
 */
public class Doencas {
	private int codigo;
	private Cliente cliente;
	private String nome;
	private ClasseProduto classe;

	public Doencas() {
		this.codigo = 0;
		this.setNome("");
		this.cliente = new Cliente();
	}

	public Doencas(int codigo) {
		this.codigo = codigo;
		this.setNome("");
		this.cliente = new Cliente();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClasseProduto getClasse() {
		return classe;
	}

	public void setClasse(ClasseProduto classe) {
		this.classe = classe;
	}

	public void setClasse(Integer classe) {
		if (classe == (ClasseProduto.CRONICA.getId())) {
			setClasse(ClasseProduto.CRONICA);
		} else if (classe == ClasseProduto.ALERGIA.getId()) {
			setClasse(ClasseProduto.ALERGIA);
		} else {
			return;
		}
	}
	public void setClasse(String classe) {
		if (classe == (ClasseProduto.CRONICA.toString())) {
			setClasse(ClasseProduto.CRONICA);
		} else if (classe == ClasseProduto.ALERGIA.toString()) {
			setClasse(ClasseProduto.ALERGIA);
		} else {
			return;
		}
	}

	@Override
	public String toString() {
		return getCliente().getNome();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Doencas) {
			Doencas dc = (Doencas) o;
			if (dc.getCodigo() == this.getCodigo()) {
				return true;
			}
		}
		return false;
	}
}
