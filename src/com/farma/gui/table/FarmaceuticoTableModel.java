package com.farma.gui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.Farmaceutico;

/**
 * Classe que define o modelo para tabela contendo dados do farmceutico
 *
 * @author Inocencio
 */
public class FarmaceuticoTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2001118601526219314L;
	private String colunas[] = {"Login", "Cargo","Nivel de Acesso"};
    private List<Farmaceutico> dados;

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
        Farmaceutico farmaceutico = dados.get(l);
        switch (c) {
            case 0:
                return farmaceutico.getLogin();
            case 1:
                return farmaceutico.getCargo();
            case 2:
            	return farmaceutico.getNivel();
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

    public void setDados(List<Farmaceutico> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Farmaceutico getRowValue(int l) {
        return dados.get(l);
    }
}
