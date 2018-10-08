package com.farma.gui;

import java.util.Date;

import javax.swing.JOptionPane;

import com.farma.bean.Cliente;
import com.farma.bean.ItemVenda;
import com.farma.bean.Produto;
import com.farma.bean.Venda;
import com.farma.bean.enums.ClasseProduto;
import com.farma.bean.enums.Situacao;
import com.farma.dao.ProdutoDAO;
import com.farma.dao.VendaDAO;
import com.farma.gui.table.ItemVendaTableModel;
import com.farma.gui.table.VendaTableModel;

/**
 * Janela de lan�amento de venda
 *
 * @author Inocencio
 */
public class LancamentoVenda extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Venda venda = null;
	private VendaDAO vendaDAO = new VendaDAO();

	public LancamentoVenda() {
		initComponents();
		habilitarFormulario(false);
		carregarGrade();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel2 = new javax.swing.JPanel();
		pnBarraFerramentas = new javax.swing.JPanel();
		barraFerramentas = new javax.swing.JToolBar();
		btNovo = new javax.swing.JButton();
		btSalvar = new javax.swing.JButton();
		btFinalizar = new javax.swing.JButton();
		btExcluir = new javax.swing.JButton();
		btCancelar = new javax.swing.JButton();
		tpConteudo = new javax.swing.JTabbedPane();
		pnCabecalho = new javax.swing.JPanel();
		pnForm = new javax.swing.JPanel();
		lbCliente = new javax.swing.JLabel();
		lbValorTotal = new javax.swing.JLabel();
		lbDataVenda = new javax.swing.JLabel();
		ftfCliente = new javax.swing.JFormattedTextField();
		btCliente = new javax.swing.JButton();
		ftfValorTotal = new javax.swing.JFormattedTextField();
		ftfDataVenda = new javax.swing.JFormattedTextField();
		spGrade = new javax.swing.JScrollPane();
		tbGrade = new javax.swing.JTable();
		pnItens = new javax.swing.JPanel();
		pnFormItens = new javax.swing.JPanel();
		lbProduto = new javax.swing.JLabel();
		lbValorUnitario = new javax.swing.JLabel();
		lbQuantidade = new javax.swing.JLabel();
		lbClasse = new javax.swing.JLabel();
		lbPercentCronica = new javax.swing.JLabel();
		ftfProduto = new javax.swing.JFormattedTextField();
		btProduto = new javax.swing.JButton();
		ftfValorUnitario = new javax.swing.JFormattedTextField();
		ftfValorUnitario.setEditable(false);
		ftfClasse = new javax.swing.JFormattedTextField();
		ftfClasse.setEditable(false);
		ftfPercentCronica = new javax.swing.JFormattedTextField();
		ftfPercentCronica.setEnabled(false);
		ftfPercentCronica.setEditable(false);
		spQuantidade = new javax.swing.JSpinner();
		btAdicionarItem = new javax.swing.JButton();
		btRemoverItem = new javax.swing.JButton();
		spGradeItens = new javax.swing.JScrollPane();
		tbGradeItens = new javax.swing.JTable();

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setClosable(true);
		setIconifiable(true);
		setTitle("Vendas");

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

		btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/finalizar.png")));
		btFinalizar.setText("Finalizar");
		btFinalizar.setFocusable(false);
		btFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btFinalizar.setMargin(new java.awt.Insets(2, 8, 2, 8));
		btFinalizar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/finalizar-foco.png")));
		btFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btFinalizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btFinalizarActionPerformed(evt);
			}
		});
		barraFerramentas.add(btFinalizar);

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
						javax.swing.BorderFactory.createTitledBorder(null, "Formul�rio",
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

		lbValorTotal.setText("Valor Total:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbValorTotal, gridBagConstraints);

		lbDataVenda.setText("Data Venda:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbDataVenda, gridBagConstraints);

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

		ftfValorTotal.setEditable(false);
		ftfValorTotal.setColumns(10);
		ftfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
		ftfValorTotal.setValue(new Double(0));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfValorTotal, gridBagConstraints);

		ftfDataVenda.setEditable(false);
		ftfDataVenda.setColumns(10);
		ftfDataVenda.setFormatterFactory(
				new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
		ftfDataVenda.setValue(new Date());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfDataVenda, gridBagConstraints);

		pnCabecalho.add(pnForm, java.awt.BorderLayout.PAGE_START);

		tbGrade.setModel(new VendaTableModel());
		tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbGradeMouseClicked(evt);
			}
		});
		spGrade.setViewportView(tbGrade);

		pnCabecalho.add(spGrade, java.awt.BorderLayout.CENTER);

		tpConteudo.addTab("Dados da venda", pnCabecalho);

		pnItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
		pnItens.setLayout(new java.awt.BorderLayout());

		pnFormItens.setBorder(
				javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0),
						javax.swing.BorderFactory.createTitledBorder(null, "Formul�rio",
								javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),
								new java.awt.Color(102, 153, 255))));
		pnFormItens.setOpaque(false);
		pnFormItens.setLayout(new java.awt.GridBagLayout());

		lbProduto.setText("Produto:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(lbProduto, gridBagConstraints);

		lbQuantidade.setText("Quantidade:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(lbQuantidade, gridBagConstraints);

		lbValorUnitario.setText("Valor Unit�rio:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(lbValorUnitario, gridBagConstraints);

		lbClasse.setText("Classe Doen�a:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(lbClasse, gridBagConstraints);

		lbPercentCronica.setText("D e s c o n t o :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(lbPercentCronica, gridBagConstraints);

		ftfProduto.setEditable(false);
		ftfProduto.setColumns(25);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(ftfProduto, gridBagConstraints);

		btProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/buscar.png")));
		btProduto.setToolTipText("Localizar produto");
		btProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btProduto.setPreferredSize(new java.awt.Dimension(21, 21));
		btProduto.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/buscar-foco.png")));
		btProduto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btProdutoActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnFormItens.add(btProduto, gridBagConstraints);

		spQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000000, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(spQuantidade, gridBagConstraints);

		ftfValorUnitario.setColumns(10);
		ftfValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
		ftfValorUnitario.setValue(new Double(0));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(ftfValorUnitario, gridBagConstraints);

		ftfClasse.setColumns(13);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(ftfClasse, gridBagConstraints);

		ftfPercentCronica.setColumns(10);
		ftfPercentCronica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
		ftfPercentCronica.setValue(new Double(0));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnFormItens.add(ftfPercentCronica, gridBagConstraints);

		btAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo.png")));
		btAdicionarItem.setToolTipText("Adicionar item");
		btAdicionarItem.setPreferredSize(new java.awt.Dimension(35, 30));
		btAdicionarItem.setEnabled(false);
		btAdicionarItem
				.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/novo-foco.png")));
		btAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btAdicionarItemActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		pnFormItens.add(btAdicionarItem, gridBagConstraints);

		btRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir.png")));
		btRemoverItem.setToolTipText("Remover item");
		btRemoverItem.setPreferredSize(new java.awt.Dimension(35, 30));
		btRemoverItem.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/excluir-foco.png")));
		btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btRemoverItemActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		pnFormItens.add(btRemoverItem, gridBagConstraints);

		pnItens.add(pnFormItens, java.awt.BorderLayout.PAGE_START);

		tbGradeItens.setModel(new ItemVendaTableModel());
		spGradeItens.setViewportView(tbGradeItens);

		pnItens.add(spGradeItens, java.awt.BorderLayout.CENTER);

		tpConteudo.addTab("Itens da venda", pnItens);

		getContentPane().add(tpConteudo, java.awt.BorderLayout.CENTER);

		setBounds(10, 10, 450, 500);
	}// </editor-fold>//GEN-END:initComponents

	private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btNovoActionPerformed
		venda = new Venda();
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

	private void btProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btProdutoActionPerformed
		BuscaProduto buscaProduto = new BuscaProduto(this);
		buscaProduto.setVisible(true);
	}// GEN-LAST:event_btProdutoActionPerformed

	private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btAdicionarItemActionPerformed
		if (validarFormularioItens()) {
			ItemVenda iv = new ItemVenda();
			iv.setProduto((Produto) ftfProduto.getValue());
			iv.setVenda(venda);
			iv.setQuantidade((int) spQuantidade.getValue());
			iv.setValorUnitario((Double) ftfValorUnitario.getValue());

			iv.setDesconto(valorPerc);
			iv.setPagar(vTotal);
			venda.addItem(iv);

			ItemVendaTableModel ivtm = (ItemVendaTableModel) tbGradeItens.getModel();
			ivtm.setDados(venda.getItens());

			ftfValorTotal.setValue(iv.getVenda().getValorTotal());

			limpaFormularioItens();
		}
	}// GEN-LAST:event_btAdicionarItemActionPerformed

	private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btRemoverItemActionPerformed
		if (tbGradeItens.getSelectedRowCount() > 0) {
			int linhaSelecionada = tbGradeItens.getSelectedRow();
			ItemVendaTableModel ivtm = (ItemVendaTableModel) tbGradeItens.getModel();
			ItemVenda iv = ivtm.getRowValue(linhaSelecionada);

			if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item " + iv + "?", "Confirma��o",
					JOptionPane.YES_NO_OPTION) == 0) {
				venda.removeItem(iv);
				ivtm.setDados(venda.getItens());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
	}// GEN-LAST:event_btRemoverItemActionPerformed

	private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbGradeMouseClicked
		if (evt.getClickCount() == 2) {
			int linhaSelecionada = tbGrade.getSelectedRow();
			VendaTableModel vtm = (VendaTableModel) tbGrade.getModel();
			venda = vtm.getRowValue(linhaSelecionada);

			if (venda.getSituacao() == Situacao.FINALIZADA) {
				JOptionPane.showMessageDialog(this, "Venda finalizada n�o pode ser alterada.", "Alerta",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (venda.getSituacao() == Situacao.CANCELADA) {
				JOptionPane.showMessageDialog(this, "Venda cancelada n�o pode ser alterada.", "Alerta",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			ftfCliente.setValue(venda.getCliente());
			ftfDataVenda.setValue(venda.getDataVenda());
			ftfValorTotal.setValue(venda.getValorTotal());
			ftfPercentCronica.setValue(valorPerc);

			ItemVendaTableModel ivtm = (ItemVendaTableModel) tbGradeItens.getModel();
			ivtm.setDados(venda.getItens());

			habilitarFormulario(true);
		}
	}// GEN-LAST:event_tbGradeMouseClicked

	private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btFinalizarActionPerformed
		int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a venda?");
		if (opcao == 0) {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			for (ItemVenda iv : venda.getItens()) {
				try {
					if (iv.getQuantidade() > produtoDAO.recuperar(iv.getProduto().getCodigo()).getQuantidade()) {
						JOptionPane.showMessageDialog(this,
								"Imposs�vel finalizar.\nProduto " + iv.getProduto() + " em falta no estoque.", "Alerta",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao consultar o estoque.", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			salvar(true);
		}
	}// GEN-LAST:event_btFinalizarActionPerformed

	private void salvar(boolean finalizar) {
		if (validarFormulario()) {
			venda.setCliente((Cliente) ftfCliente.getValue());
			venda.setDataVenda((Date) ftfDataVenda.getValue());
			if (finalizar) {
				venda.setSituacao(Situacao.FINALIZADA);
			} else {
				venda.setSituacao(Situacao.ABERTA);
			}
			if (venda.getCodigo() == 0) {
				try {
					vendaDAO.inserir(venda);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao inserir a venda.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
			} else {
				try {
					vendaDAO.alterar(venda);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Erro ao alterar a venda.\n" + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			habilitarFormulario(false);
			carregarGrade();
		}
	}

	private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btExcluirActionPerformed
		int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a venda " + venda + "?");
		if (opcao == 0) {
			try {
				vendaDAO.excluir(venda);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao excluir a venda.\n" + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			habilitarFormulario(false);
			carregarGrade();
		}
	}// GEN-LAST:event_btExcluirActionPerformed

	private int codigo;

	public void setCliente(Cliente cliente) {
		ftfCliente.setValue(cliente);
		codigo = cliente.getCodigo();
	}

	Double vTotal;
	Double valorPerc;
	Double percRecorrente = 0.00;

	public void setProduto(Produto produto) throws Exception {
		ftfProduto.setValue(produto);
		ftfValorUnitario.setValue(produto.getPrecoVenda());
		ftfClasse.setValue(produto.getClasse());

		Double valorVenda = (Double) produto.getPrecoVenda();
		int qtd = (int) spQuantidade.getValue();
		Double valorVendaTotal = (valorVenda * qtd);
		ClasseProduto classe = (ClasseProduto) produto.getClasse();
		
		Venda v = (Venda) vendaDAO.recuperar(codigo);
		
		if (codigo == v.getCliente().getCodigo()) {
			if (JOptionPane
					.showConfirmDialog(
							this, "Este cliente j� comprou o " + produto
									+ " anteriormente. Ser� aplicado um desconto de " + produto.getDesconto(),
							"Confirma��o", JOptionPane.YES_NO_OPTION) == 0) {
				percRecorrente = (double) produto.getDesconto();
				percRecorrente = (valorVendaTotal * percRecorrente) / 100;
				System.out.println("Percentagem da compra recorrente R$ " + percRecorrente);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID do cliente n�o � igual ao Id contido na tabela de venda!");
		}

		if (ClasseProduto.CRONICA.equals(classe)) {

			if (JOptionPane.showConfirmDialog(this, "O medicamento " + produto
					+ " � para doen�as cr�nicas, ser� aplicado um desconto de " + produto.getDesconto(), "Confirma��o",
					JOptionPane.YES_NO_OPTION) == 0) {
				Double percetual = (Double) produto.getDesconto();
				valorPerc = ((valorVendaTotal * percetual) / 100);
				ftfPercentCronica.setValue(valorPerc + percRecorrente);
				vTotal = valorVendaTotal - (valorPerc + percRecorrente);
			} else {
				limpaFormularioItens();
			}
		} else if (ClasseProduto.ALERGIA.equals(classe)) {
			if (JOptionPane.showConfirmDialog(this,
					"O medicamento " + produto + " cont�m alerg�nico, deseja adicionar mesmo assim ?", "Confirma��o",
					JOptionPane.YES_NO_OPTION) == 0) {
				ftfPercentCronica.setValue(null);
				valorPerc = 0.00;
				vTotal = valorVendaTotal + percRecorrente;

			} else {
				limpaFormularioItens();
			}
		}
	}

	private void habilitarFormulario(boolean ativo) {
		btNovo.setEnabled(!ativo);
		btSalvar.setEnabled(ativo);
		btFinalizar.setEnabled(ativo);
		btExcluir.setEnabled(ativo);
		btCancelar.setEnabled(ativo);
		ftfCliente.setEnabled(ativo);
		btCliente.setEnabled(ativo);

		ftfDataVenda.setEnabled(ativo);
		ftfValorTotal.setEnabled(ativo);
		ftfProduto.setEnabled(ativo);
		btProduto.setEnabled(ativo);
		spQuantidade.setEnabled(ativo);
		ftfValorUnitario.setEnabled(ativo);
		ftfClasse.setEnabled(ativo);
		ftfPercentCronica.setEnabled(ativo);

		btAdicionarItem.setEnabled(ativo);
		btRemoverItem.setEnabled(ativo);
		tbGrade.setEnabled(!ativo);

		if (!ativo) {
			limpaFormulario();
		}
	}

	private void limpaFormulario() {
		venda = null;
		ftfCliente.setValue(null);
		ftfDataVenda.setValue(new Date());
		ftfValorTotal.setValue(new Double(0));
		ftfProduto.setValue(null);
		spQuantidade.setValue(1);
		ftfValorUnitario.setValue(new Double(0));
		tbGradeItens.setModel(new ItemVendaTableModel());
		limpaFormularioItens();
	}

	private void limpaFormularioItens() {
		ftfProduto.setValue(null);
		spQuantidade.setValue(1);
		ftfValorUnitario.setValue(new Double(0));
		ftfClasse.setValue(null);
		ftfPercentCronica.setValue(new Double(0));
	}

	private boolean validarFormulario() {
		if (ftfCliente.getValue() == null) {
			JOptionPane.showMessageDialog(this, "Cliente inv�lido.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfCliente.requestFocus();
			return false;
		}
		if (venda.quantidadeItens() == 0) {
			JOptionPane.showMessageDialog(this, "Quantidade de itens inv�lida.", "Alerta", JOptionPane.WARNING_MESSAGE);
			tpConteudo.setSelectedIndex(1);
			return false;
		}
		return true;
	}

	private boolean validarFormularioItens() {
		if (ftfProduto.getValue() == null) {
			JOptionPane.showMessageDialog(this, "Produto inv�lido.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfProduto.requestFocus();
			return false;
		}
		if (ftfClasse.getValue() == null) {
			JOptionPane.showMessageDialog(this, "Classe de Doen�a inv�lida.", "Alerta", JOptionPane.WARNING_MESSAGE);
			ftfProduto.requestFocus();
			return false;
		}
		return true;
	}

	private void carregarGrade() {
		VendaTableModel tm = (VendaTableModel) tbGrade.getModel();
		try {
			tm.setDados(vendaDAO.listarTodos());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			// ex.printStackTrace();
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToolBar barraFerramentas;
	private javax.swing.JButton btAdicionarItem;
	private javax.swing.JButton btCancelar;
	private javax.swing.JButton btCliente;
	private javax.swing.JButton btExcluir;
	private javax.swing.JButton btFinalizar;
	private javax.swing.JButton btNovo;
	private javax.swing.JButton btProduto;
	private javax.swing.JButton btRemoverItem;
	private javax.swing.JButton btSalvar;
	private javax.swing.JFormattedTextField ftfCliente;
	private javax.swing.JFormattedTextField ftfDataVenda;
	private javax.swing.JFormattedTextField ftfProduto;
	private javax.swing.JFormattedTextField ftfValorTotal;
	private javax.swing.JFormattedTextField ftfValorUnitario;
	private javax.swing.JFormattedTextField ftfClasse;
	private javax.swing.JFormattedTextField ftfPercentCronica;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel lbCliente;
	private javax.swing.JLabel lbDataVenda;
	private javax.swing.JLabel lbProduto;
	private javax.swing.JLabel lbQuantidade;
	private javax.swing.JLabel lbValorTotal;
	private javax.swing.JLabel lbValorUnitario;
	private javax.swing.JLabel lbClasse;
	private javax.swing.JLabel lbPercentCronica;
	private javax.swing.JPanel pnBarraFerramentas;
	private javax.swing.JPanel pnCabecalho;
	private javax.swing.JPanel pnForm;
	private javax.swing.JPanel pnFormItens;
	private javax.swing.JPanel pnItens;
	private javax.swing.JScrollPane spGrade;
	private javax.swing.JScrollPane spGradeItens;
	private javax.swing.JSpinner spQuantidade;
	private javax.swing.JTable tbGrade;
	private javax.swing.JTable tbGradeItens;
	private javax.swing.JTabbedPane tpConteudo;
	// End of variables declaration//GEN-END:variables
}
