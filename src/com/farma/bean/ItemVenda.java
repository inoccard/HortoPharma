package com.farma.bean;

/**
 * Classe de relação entre a venda e o produto
 *
 * @author Inocencio
 */
public class ItemVenda {

    private int codigo;
    private Venda venda;
    private Produto produto;
    private int quantidade;
    private Double valorUnitario;
    private Double desconto;
    private Double pagar;

    public ItemVenda() {
        this.codigo = 0;
        this.venda = new Venda();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
        this.desconto = 0.0;
        this.pagar = 00.00;
    }

    public ItemVenda(int codigo) {
        this.codigo = codigo;
        this.venda = new Venda();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
        this.pagar = 00.00;
        this.desconto = 0.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPagar() {
		return pagar;
	}

	public void setPagar(Double pagar) {
		this.pagar = pagar;
	}

	@Override
    public String toString() {
        return getProduto().getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemVenda) {
            ItemVenda iv = (ItemVenda) o;
            if (iv.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}