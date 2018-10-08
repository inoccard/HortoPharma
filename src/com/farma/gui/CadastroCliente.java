package com.farma.gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.farma.bean.Cliente;
import com.farma.bean.Doencas;
import com.farma.dao.ClienteDAO;
import com.farma.dao.DoencaDAO;
import com.farma.gui.table.ClienteTableModel;

/**
 * Janela de cadastro de cliente
 *
 * @author Inocencio
 */
public class CadastroCliente extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente = null;
	private ClienteDAO clienteDAO = new ClienteDAO();
	Doencas doenca = null;
	DoencaDAO doencaDAO = new DoencaDAO();

	public CadastroCliente() {
		initComponents();
		habilitarFormulario(false);
		carregarGrade();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnBarraFerramentas = new javax.swing.JPanel();
		barraFerramentas = new javax.swing.JToolBar();
		btNovo = new javax.swing.JButton();
		btSalvar = new javax.swing.JButton();
		btExcluir = new javax.swing.JButton();
		btCancelar = new javax.swing.JButton();
		pnConteudo = new javax.swing.JPanel();
		pnForm = new javax.swing.JPanel();
		lbNome = new javax.swing.JLabel();
		lbCpf = new javax.swing.JLabel();
		//cmbClasse = new javax.swing.JComboBox<>();
		lbClasse = new javax.swing.JLabel();
		lbDataNascimento = new javax.swing.JLabel();
		ftfNome = new javax.swing.JFormattedTextField();
		ftfCpf = new javax.swing.JFormattedTextField();
		ftfDataNascimento = new javax.swing.JFormattedTextField();
		spGrade = new javax.swing.JScrollPane();
		tbGrade = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("Cadastro de clientes");

		pnBarraFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
		pnBarraFerramentas.setOpaque(false);
		pnBarraFerramentas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		barraFerramentas.setFloatable(false);

		btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo.png"))); // NOI18N
		btNovo.setText("Novo");
		btNovo.setFocusable(false);
		btNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btNovo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo-foco.png"))); // NOI18N
		btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btNovoActionPerformed(evt);
			}
		});
		barraFerramentas.add(btNovo);

		btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/salvar.png"))); // NOI18N
		btSalvar.setText("Salvar");
		btSalvar.setFocusable(false);
		btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btSalvar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/salvar-foco.png"))); // NOI18N
		btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSalvarActionPerformed(evt);
			}
		});
		barraFerramentas.add(btSalvar);

		btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir.png"))); // NOI18N
		btExcluir.setText("Excluir");
		btExcluir.setFocusable(false);
		btExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btExcluir.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir-foco.png"))); // NOI18N
		btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btExcluirActionPerformed(evt);
			}
		});
		barraFerramentas.add(btExcluir);

		btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cancelar.png"))); // NOI18N
		btCancelar.setText("Cancelar");
		btCancelar.setFocusable(false);
		btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btCancelar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cancelar-foco.png"))); // NOI18N
		btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCancelarActionPerformed(evt);
			}
		});
		barraFerramentas.add(btCancelar);

		pnBarraFerramentas.add(barraFerramentas);

		getContentPane().add(pnBarraFerramentas, java.awt.BorderLayout.PAGE_START);

		pnConteudo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
		pnConteudo.setLayout(new java.awt.BorderLayout());

		pnForm.setBorder(
				javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0),
						javax.swing.BorderFactory.createTitledBorder(null, "Formulário",
								javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),
								new java.awt.Color(102, 153, 255)))); // NOI18N
		pnForm.setOpaque(false);
		pnForm.setLayout(new java.awt.GridBagLayout());

		lbNome.setText("Nome:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbNome, gridBagConstraints);

		lbCpf.setText("CPF:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbCpf, gridBagConstraints);

		lbDataNascimento.setText("Data Nascimento:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbDataNascimento, gridBagConstraints);

		lbClasse.setText("Possui Doença?");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		pnForm.add(lbClasse, gridBagConstraints);

		ftfNome.setColumns(25);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfNome, gridBagConstraints);

		ftfCpf.setColumns(10);
		try {
			ftfCpf.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		ftfCpf.setValue(new String());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfCpf, gridBagConstraints);

		ftfDataNascimento.setColumns(10);
		ftfDataNascimento.setFormatterFactory(
				new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
		ftfDataNascimento.setValue(new Date());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfDataNascimento, gridBagConstraints);

/*		cmbClasse.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE", "CRONICA", "ALERGIA" }));
		cmbClasse.setBounds(547, 11, 205, 20);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new Insets(2, 2, 4, 2);
		pnForm.add(cmbClasse, gridBagConstraints); */

		pnConteudo.add(pnForm, java.awt.BorderLayout.PAGE_START);

		tbGrade.setAutoCreateRowSorter(true);
		tbGrade.setModel(new ClienteTableModel());
		tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbGradeMouseClicked(evt);
			}
		});
		spGrade.setViewportView(tbGrade);

		pnConteudo.add(spGrade, java.awt.BorderLayout.CENTER);

		getContentPane().add(pnConteudo, java.awt.BorderLayout.CENTER);

		setBounds(10, 10, 405, 450);
	}// </editor-fold>//GEN-END:initComponents

	private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btNovoActionPerformed
		cliente = new Cliente();

		habilitarFormulario(true);
		btExcluir.setEnabled(false);
	}// GEN-LAST:event_btNovoActionPerformed

	private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSalvarActionPerformed
		if (validarFormulario()) {
			cliente.setNome(ftfNome.getText().trim());
			cliente.setCpf((String) ftfCpf.getText());
			cliente.setDataNascimento((Date) ftfDataNascimento.getValue());
			/*
			 * if (cmbClasse.getSelectedItem() == "CRONICA") {
			 * cliente.getDoencas().setClasse(1); } else if (cmbClasse.getSelectedItem() ==
			 * "ALERGIA") { cliente.getDoencas().setClasse(2); } else {
			 * JOptionPane.showMessageDialog(this, "Selecione um item de Classe.\nErro",
			 * "Alerta", JOptionPane.ERROR_MESSAGE); }
			 */
			if (cliente.getCodigo() == 0) {
				try {
					clienteDAO.inserir(cliente);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao inserir o cliente.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
			} else {
				try {
					clienteDAO.alterar(cliente);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao alterar o cliente.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
			}

			habilitarFormulario(false);
			carregarGrade();
			new CadastroDoenca().setVisible(true);
		}
	}// GEN-LAST:event_btSalvarActionPerformed

	private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btExcluirActionPerformed
		int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o cliente " + cliente + "?");
		if (opcao == 0) {
			try {
				clienteDAO.excluir(cliente);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao excluir o cliente.\n" + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			habilitarFormulario(false);
			carregarGrade();
		}
	}// GEN-LAST:event_btExcluirActionPerformed

	private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btCancelarActionPerformed
		habilitarFormulario(false);
	}// GEN-LAST:event_btCancelarActionPerformed

	private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbGradeMouseClicked
		if (evt.getClickCount() == 2) {
			ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
			cliente = tm.getRowValue(tbGrade.getRowSorter().convertRowIndexToModel(tbGrade.getSelectedRow()));

			ftfNome.setValue(cliente.getNome());
			ftfCpf.setValue(cliente.getCpf());
			ftfDataNascimento.setValue(cliente.getDataNascimento());
			
/*	BuscaDoenca bd = new BuscaDoenca(this);
			bd.setVisible(true);		
 * try {
				List<Doencas> lista = doencaDAO.recuperarDoencasPorCliente(cliente.getCodigo());
				if (doenca.getNome().equals(ClasseProduto.CRONICA)) {
					cmbClasse.setSelectedItem(ClasseProduto.CRONICA.toString().trim().toUpperCase());
				} else if (doenca.getNome().equals(ClasseProduto.ALERGIA)) {
					cmbClasse.setSelectedItem(ClasseProduto.ALERGIA.toString().trim().toUpperCase());
				} else {
					JOptionPane.showMessageDialog(this, "Este cliente não possui alguma doença\n", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Doença não encontrada!\n" + e.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return;
			} */
			/*
			 * if (cliente.getDoencas().getClasse() == ClasseProduto.CRONICA) {
			 * cmbClasse.setSelectedItem("CRONICA"); } else if
			 * (cliente.getDoencas().getClasse() == ClasseProduto.ALERGIA) {
			 * cmbClasse.setSelectedItem("ALERGIA"); }
			 */
			habilitarFormulario(true);
		}
	}// GEN-LAST:event_tbGradeMouseClicked

	public void setDoenca(Doencas doenca2) {
		//cmbClasse.setSelectedItem(doenca2.getNome());
	}

	private void habilitarFormulario(boolean ativo) {
		btNovo.setEnabled(!ativo);
		btSalvar.setEnabled(ativo);
		btExcluir.setEnabled(ativo);
		btCancelar.setEnabled(ativo);
		ftfNome.setEnabled(ativo);
		ftfCpf.setEnabled(ativo);
		ftfDataNascimento.setEnabled(ativo);
		//cmbClasse.setEnabled(ativo);
		tbGrade.setEnabled(!ativo);

		if (!ativo) {
			limpaFormulario();
		}
	}

	private void limpaFormulario() {
		cliente = null;
		ftfNome.setValue("");
		ftfCpf.setValue("");
		ftfDataNascimento.setValue(new Date());
		//cmbClasse.setSelectedItem("SELECIONE");
	}

	private boolean validarFormulario() {
		if (ftfNome.getText().trim().length() < 2) {
			JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfNome.requestFocus();
			return false;
		}

		if (((Date) ftfDataNascimento.getValue()).after(new Date())) {
			JOptionPane.showMessageDialog(this, "Data de nascimento inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfDataNascimento.requestFocus();
			return false;
		}
		return true;
	}

	private void carregarGrade() {
		ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
		try {
			tm.setDados(clienteDAO.listarTodos());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToolBar barraFerramentas;
	private javax.swing.JButton btCancelar;
	private javax.swing.JButton btExcluir;
	private javax.swing.JButton btNovo;
	private javax.swing.JButton btSalvar;
	private javax.swing.JFormattedTextField ftfDataNascimento;
	private javax.swing.JFormattedTextField ftfNome;
	private javax.swing.JFormattedTextField ftfCpf;
	private javax.swing.JLabel lbCpf;
	private javax.swing.JLabel lbDataNascimento;
	@SuppressWarnings("rawtypes")
//	private javax.swing.JComboBox cmbClasse;
	private javax.swing.JLabel lbClasse;
	private javax.swing.JLabel lbNome;
	private javax.swing.JPanel pnBarraFerramentas;
	private javax.swing.JPanel pnConteudo;
	private javax.swing.JPanel pnForm;
	private javax.swing.JScrollPane spGrade;
	private javax.swing.JTable tbGrade;
	// End of variables declaration//GEN-END:variables
}
