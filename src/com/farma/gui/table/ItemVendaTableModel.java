package com.farma.gui.table;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.ItemVenda;

/**
 * Classe que define o modelo para tabela contendo dados dos itens da venda
 *
 * @author Inocencio
 */
public class ItemVendaTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8114381468950374747L;
	private final NumberFormat NF = NumberFormat.getNumberInstance();
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Produto","Classe", "Quantidade", "Valor Unit.", "Desconto", "Pagar"};
    private List<ItemVenda> dados;

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
        ItemVenda itemVenda = dados.get(l);
        switch (c) {
            case 0:
                return itemVenda.getProduto().getNome();
            case 1:
            	return NF.format(itemVenda.getProduto().getClasse().getId());
            case 2:
                return NF.format(itemVenda.getQuantidade());
            case 3:
                return NFC.format(itemVenda.getValorUnitario());
            case 4:
            	return NFC.format(itemVenda.getDesconto());
            case 5:
            	return NFC.format(itemVenda.getPagar());
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

    public void setDados(List<ItemVenda> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ItemVenda getRowValue(int l) {
        return dados.get(l);
    }
}
