package com.farma.gui;

import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.farma.bean.Cliente;
import com.farma.bean.Doencas;
import com.farma.bean.enums.ClasseProduto;
import com.farma.dao.DoencaDAO;
import com.farma.gui.table.DoencaTableModel;

/**
 * Janela de lançamento de venda
 *
 * @author Inocencio
 */
public class CadastroDoenca extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7517925199084954235L;
	private Doencas doenca = null;
	private DoencaDAO doencaDAO = new DoencaDAO();

	public CadastroDoenca() {
		initComponents();
		habilitarFormulario(false);
		carregarGrade();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel2 = new javax.swing.JPanel();
		pnBarraFerramentas = new javax.swing.JPanel();
		barraFerramentas = new javax.swing.JToolBar();
		btNovo = new javax.swing.JButton();
		btSalvar = new javax.swing.JButton();
		btExcluir = new javax.swing.JButton();
		btCancelar = new javax.swing.JButton();
		tpConteudo = new javax.swing.JTabbedPane();
		pnCabecalho = new javax.swing.JPanel();
		pnForm = new javax.swing.JPanel();
		lbCliente = new javax.swing.JLabel();
		lbNomeDoenca = new javax.swing.JLabel();
		ftfCliente = new javax.swing.JFormattedTextField();
		btCliente = new javax.swing.JButton();
		cmbNomeDoenca = new javax.swing.JComboBox<ClasseProduto>();
		spGrade = new javax.swing.JScrollPane();
		tbGrade = new javax.swing.JTable();

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setClosable(true);
		setIconifiable(true);
		setTitle("Cadastro de Doenças");

		pnBarraFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
		pnBarraFerramentas.setOpaque(false);
		pnBarraFerramentas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		barraFerramentas.setFloatable(false);

		btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo.png")));
		btNovo.setText("Novo");
		btNovo.setFocusable(false);
		btNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btNovo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo-foco.png")));
		btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btNovoActionPerformed(evt);
			}
		});
		barraFerramentas.add(btNovo);

		btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/salvar.png")));
		btSalvar.setText("Salvar");
		btSalvar.setFocusable(false);
		btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btSalvar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/salvar-foco.png")));
		btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSalvarActionPerformed(evt);
			}
		});
		barraFerramentas.add(btSalvar);

		btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir.png")));
		btExcluir.setText("Excluir");
		btExcluir.setFocusable(false);
		btExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btExcluir.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir-foco.png")));
		btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btExcluirActionPerformed(evt);
			}
		});
		barraFerramentas.add(btExcluir);

		btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cancelar.png")));
		btCancelar.setText("Cancelar");
		btCancelar.setFocusable(false);
		btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btCancelar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cancelar-foco.png")));
		btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCancelarActionPerformed(evt);
			}
		});
		barraFerramentas.add(btCancelar);

		pnBarraFerramentas.add(barraFerramentas);

		getContentPane().add(pnBarraFerramentas, java.awt.BorderLayout.PAGE_START);

		pnCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
		pnCabecalho.setLayout(new java.awt.BorderLayout());

		pnForm.setBorder(
				javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0),
						javax.swing.BorderFactory.createTitledBorder(null, "Formulário",
								javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),
								new java.awt.Color(102, 153, 255))));
		pnForm.setOpaque(false);
		pnForm.setLayout(new java.awt.GridBagLayout());

		lbCliente.setText("Cliente:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbCliente, gridBagConstraints);

		lbNomeDoenca.setText("Nome Doen\u00E7a:");
		gbc_lbNomeDoenca = new java.awt.GridBagConstraints();
		gbc_lbNomeDoenca.gridx = 0;
		gbc_lbNomeDoenca.gridy = 2;
		gbc_lbNomeDoenca.anchor = java.awt.GridBagConstraints.LINE_END;
		gbc_lbNomeDoenca.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbNomeDoenca, gbc_lbNomeDoenca);

		ftfCliente.setEditable(false);
		ftfCliente.setColumns(25);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfCliente, gridBagConstraints);

		btCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/buscar.png")));
		btCliente.setToolTipText("Localizar cliente");
		btCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btCliente.setPreferredSize(new java.awt.Dimension(21, 21));
		btCliente.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/buscar-foco.png")));
		btCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btClienteActionPerformed(evt);
			}
		});
		pnForm.add(btCliente, new java.awt.GridBagConstraints());

		cmbNomeDoenca.setEditable(false);
		cmbNomeDoenca.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE", "CRONICA", "ALERGIA" }));
		cmbNomeDoenca.setBounds(547, 11, 205, 20);
		gbc_ftfNomeDoenca = new java.awt.GridBagConstraints();
		gbc_ftfNomeDoenca.gridx = 1;
		gbc_ftfNomeDoenca.gridy = 2;
		gbc_ftfNomeDoenca.anchor = java.awt.GridBagConstraints.LINE_START;
		gbc_ftfNomeDoenca.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(cmbNomeDoenca, gbc_ftfNomeDoenca);

		pnCabecalho.add(pnForm, java.awt.BorderLayout.PAGE_START);

		tbGrade.setModel(new DoencaTableModel());
		tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbGradeMouseClicked(evt);
			}
		});
		spGrade.setViewportView(tbGrade);

		pnCabecalho.add(spGrade, java.awt.BorderLayout.CENTER);

		tpConteudo.addTab("Dados das Doenças", pnCabecalho);

		getContentPane().add(tpConteudo, java.awt.BorderLayout.CENTER);

		setBounds(10, 10, 450, 500);
	}// </editor-fold>//GEN-END:initComponents

	private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btNovoActionPerformed
		doenca = new Doencas();
		habilitarFormulario(true);
	}// GEN-LAST:event_btNovoActionPerformed

	private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSalvarActionPerformed
		salvar(false);
	}// GEN-LAST:event_btSalvarActionPerformed

	private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btCancelarActionPerformed
		habilitarFormulario(false);
	}// GEN-LAST:event_btCancelarActionPerformed

	private void btClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btClienteActionPerformed
		BuscaCliente buscaCliente = new BuscaCliente(this);
		buscaCliente.setVisible(true);
	}// GEN-LAST:event_btClienteActionPerformed

	private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbGradeMouseClicked
		if (evt.getClickCount() == 2) {
			int linhaSelecionada = tbGrade.getSelectedRow();
			DoencaTableModel vtm = (DoencaTableModel) tbGrade.getModel();
			doenca = vtm.getRowValue(linhaSelecionada);

			ftfCliente.setValue(doenca.getCliente());
			cmbNomeDoenca.setSelectedItem(doenca.getNome());
			habilitarFormulario(true);
		}
	}// GEN-LAST:event_tbGradeMouseClicked

	private void salvar(boolean finalizar) {
		if (validarFormulario()) {
			doenca.setCliente((Cliente) ftfCliente.getValue());
			doenca.setNome((String) cmbNomeDoenca.getSelectedItem());
			if (doenca.getCodigo() == 0) {
				try {
					doencaDAO.inserir(doenca);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao inserir a doença.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
			} else {
				try {
					doencaDAO.alterar(doenca);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao alterar a doença.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			habilitarFormulario(false);
			carregarGrade();
		}
	}

	private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btExcluirActionPerformed
		int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a venda " + doenca + "?");
		if (opcao == 0) {
			try {
				doencaDAO.excluir(doenca);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao excluir a venda.\n" + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			habilitarFormulario(false);
			carregarGrade();
		}
	}// GEN-LAST:event_btExcluirActionPerformed

	public void setCliente(Cliente cliente) {
		ftfCliente.setValue(cliente);
	}

	private void habilitarFormulario(boolean ativo) {
		btNovo.setEnabled(!ativo);
		btSalvar.setEnabled(ativo);
		btExcluir.setEnabled(ativo);
		btCancelar.setEnabled(ativo);
		ftfCliente.setEnabled(ativo);
		btCliente.setEnabled(ativo);
		cmbNomeDoenca.setEnabled(ativo);
		tbGrade.setEnabled(!ativo);

		if (!ativo) {
			limpaFormulario();
		}
	}

	private void limpaFormulario() {
		doenca = null;
		ftfCliente.setValue(null);
		cmbNomeDoenca.setSelectedItem("SELECIONE");
	}

	private boolean validarFormulario() {
		if (ftfCliente.getValue() == null) {
			JOptionPane.showMessageDialog(this, "Cliente inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfCliente.requestFocus();
			return false;
		}
		if (cmbNomeDoenca.getSelectedItem().equals("SELECIONE")) {
			JOptionPane.showMessageDialog(this, "Nome de doença inválida, escolha uma doença na lista.", "Alerta",
					JOptionPane.WARNING_MESSAGE);
			cmbNomeDoenca.requestFocus();
			return false;
		}
		return true;
	}

	private void carregarGrade() {
		DoencaTableModel tm = (DoencaTableModel) tbGrade.getModel();
		try {
			tm.setDados(doencaDAO.listarTodos());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToolBar barraFerramentas;
	private javax.swing.JButton btCancelar;
	private javax.swing.JButton btCliente;
	private javax.swing.JButton btExcluir;
	private javax.swing.JButton btNovo;
	private javax.swing.JButton btSalvar;
	private javax.swing.JFormattedTextField ftfCliente;
	private javax.swing.JComboBox<ClasseProduto> cmbNomeDoenca;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel lbCliente;
	private javax.swing.JLabel lbNomeDoenca;
	private javax.swing.JPanel pnBarraFerramentas;
	private javax.swing.JPanel pnCabecalho;
	private javax.swing.JPanel pnForm;
	private javax.swing.JScrollPane spGrade;
	private javax.swing.JTable tbGrade;
	private javax.swing.JTabbedPane tpConteudo;
	private GridBagConstraints gbc_lbNomeDoenca;
	private GridBagConstraints gbc_ftfNomeDoenca;
	// End of variables declaration//GEN-END:variables

}
