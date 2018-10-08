package com.farma.gui.table;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.Compra;

/**
 * Classe que define o modelo para tabela contendo dados da compra
 *
 * @author Inocencio
 */
public class CompraTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1832119666367531182L;
	private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Fornecedor", "Data", "Valor", "Situação"};
    private List<Compra> dados;

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
        Compra compra = dados.get(l);
        switch (c) {
            case 0:
                return compra.getFornecedor().getNome();
            case 1:
                return SDF.format(compra.getDataCompra());
            case 2:
                return NFC.format(compra.getValorTotal());
            case 3:
                return compra.getSituacao();
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

    public void setDados(List<Compra> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Compra getRowValue(int l) {
        return dados.get(l);
    }
}
