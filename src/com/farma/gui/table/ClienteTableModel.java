package com.farma.gui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.Cliente;

/**
 * Classe que define o modelo para tabela contendo dados do cliente
 *
 * @author Inocencio
 */
public class ClienteTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1259729924278227836L;
	private String colunas[] = {"Nome", "CPF"};
    private List<Cliente> dados;

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
        Cliente cliente = dados.get(l);
        switch (c) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpf();
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

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Cliente getRowValue(int l) {
        return dados.get(l);
    }
}
