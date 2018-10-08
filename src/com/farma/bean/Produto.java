package com.farma.bean;

import com.farma.bean.enums.ClasseProduto;

/**
 * Classe contendo os dados do produto
 *
 * @author Inocencio
 */
public class Produto {

    private int codigo;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private int quantidade;
    private ClasseProduto classe;
    private Double desconto;

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.precoCompra = 0.00;
        this.precoVenda = 0.00;
        this.quantidade = 0;
        this.classe = null;
        this.desconto = 0.00;
    }

    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.precoCompra = 0.00;
        this.precoVenda = 0.00;
        this.quantidade = 0;
        this.classe = null;
        this.desconto = 0.00;
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

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public ClasseProduto getClasse() {
		return classe;
	}

	public void setClasse(ClasseProduto classe) {
		this.classe = classe;
	}
	public void setClasse(Integer classe) {
		if(classe == (ClasseProduto.CRONICA.getId())) {
			setClasse(ClasseProduto.CRONICA);
		} else if(classe == ClasseProduto.ALERGIA.getId()){
			setClasse(ClasseProduto.ALERGIA);
		} else {
			return;
		}
	}
	public void setClasse(String classe) {
		if(classe == (ClasseProduto.CRONICA.toString())) {
			setClasse(ClasseProduto.CRONICA);
		} else if(classe == ClasseProduto.ALERGIA.toString()){
			setClasse(ClasseProduto.ALERGIA);
		} else {
			return;
		}
	}
    public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	@Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
