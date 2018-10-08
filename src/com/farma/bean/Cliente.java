package com.farma.bean;

import java.util.Date;
import java.util.List;

/**
 * Classe contendo os dados do cliente
 *
 * @author Inocencio
 */
public class Cliente {

    private int codigo;
    private Doencas doenca;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Doencas> doencas;

    public Cliente() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
    }

    public Cliente(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Doencas getDoencas() {
		return doenca;
	}

	public void setDoenca(Doencas doenca) {
		this.doenca = doenca;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNasc) {
        this.dataNascimento = dataNasc;
    }

    public List<Doencas> getListDoencas() {
		return doencas;
	}

	public void addDoenca(Doencas doencas) {
		this.doencas.add(doencas);
	}

	@Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
