package com.farma.gui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.farma.bean.Doencas;

/**
 * Classe que define o modelo para tabela contendo dados da doença
 *
 * @author Inocencio
 */
public class DoencaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1832119666367531182L;
	private String colunas[] = { "Nome Doença", "Cliente" };
	private List<Doencas> dados;

	@Override
	public int getRowCount() {
		if (dados == null) {
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
		Doencas doenca = dados.get(l);
		switch (c) {
		case 0:
			return doenca.getNome();
		case 1:
			return doenca.getCliente().getNome();
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

	public void setDados(List<Doencas> dados) {
		this.dados = dados;
		fireTableDataChanged();
	}

	public Doencas getRowValue(int l) {
		return dados.get(l);
	}
}
