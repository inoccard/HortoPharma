package com.farma.gui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.Produto;

/**
 * Classe que define o modelo para tabela contendo dados do produto
 *
 * @author Inocencio
 */
public class ProdutoTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String colunas[] = {"Nome", "Classe", "Desconto"};
    private List<Produto> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Produto produto = dados.get(l);
        switch (c) {
            case 0:
                return produto.getNome();
            case 1:
            	return produto.getClasse();
            case 2:
            	return produto.getDesconto();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Produto> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Produto getRowValue(int l) {
        return dados.get(l);
    }
}
