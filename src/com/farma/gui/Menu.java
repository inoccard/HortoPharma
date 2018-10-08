package com.farma.gui;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 * Janela menu da apli��o
 *
 * @author Inocencio
 */
public class Menu extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1975517914608202542L;

	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/farma/gui/img/venda.png")));
		initComponents();
	}
	
	public Menu(int nivel, String login) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/farma/gui/img/venda.png")));
		initComponents();

		if (nivel == 0) {
			HabilitaItensMenuGerente(true);
			lblSeulogin.setText(login);
		} else if (nivel == 1) {
			HabilitaItensMenuAtendente(true);
			lblSeulogin.setText(login);
		} else if (nivel == 2) {
			HabilitaItensMenuEstoquista(true);
			lblSeulogin.setText(login);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		toolBar = new javax.swing.JToolBar();
		btVenda = new javax.swing.JButton();
		btCompra = new javax.swing.JButton();
		btProduto = new javax.swing.JButton();
		btCliente = new javax.swing.JButton();
		btFornecedor = new javax.swing.JButton();
		btSair = new javax.swing.JButton();
		desktopPane = new javax.swing.JDesktopPane();
		menuBar = new javax.swing.JMenuBar();
		menuCadastros = new javax.swing.JMenu();
		miProduto = new javax.swing.JMenuItem();
		miCliente = new javax.swing.JMenuItem();
		miFornecedor = new javax.swing.JMenuItem();
		miFarmceutico = new javax.swing.JMenuItem();
		miDoenca = new javax.swing.JMenuItem();
		menuMovimentos = new javax.swing.JMenu();
		miVenda = new javax.swing.JMenuItem();
		miCompra = new javax.swing.JMenuItem();
		menuSistema = new javax.swing.JMenu();
		miSobre = new javax.swing.JMenuItem();
		miSair = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("SISTEMA HORTOFARMA");

		toolBar.setFloatable(false);

		btVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/venda.png"))); // NOI18N
		btVenda.setText("Venda");
		btVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btVenda.setFocusable(false);
		btVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btVenda.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btVenda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/venda-foco.png"))); // NOI18N
		btVenda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		btVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btVenda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miVendaActionPerformed(evt);
			}
		});
		toolBar.add(btVenda);

		btCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/compra.png"))); // NOI18N
		btCompra.setText("Compra");
		btCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btCompra.setFocusable(false);
		btCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btCompra.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btCompra.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/compra-foco.png"))); // NOI18N
		btCompra.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		btCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btCompra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miCompraActionPerformed(evt);
			}
		});
		toolBar.add(btCompra);

		btProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/produto.png"))); // NOI18N
		btProduto.setText("Produto");
		btProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btProduto.setFocusable(false);
		btProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btProduto.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btProduto.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/produto-foco.png"))); // NOI18N
		btProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btProduto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miProdutoActionPerformed(evt);
			}
		});
		toolBar.add(btProduto);

		btCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cliente.png"))); // NOI18N
		btCliente.setText("Cliente");
		btCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btCliente.setFocusable(false);
		btCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btCliente.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btCliente.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cliente-foco.png"))); // NOI18N
		btCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miClienteActionPerformed(evt);
			}
		});
		toolBar.add(btCliente);

		btFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/fornecedor.png"))); // NOI18N
		btFornecedor.setText("Fornecedor");
		btFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btFornecedor.setFocusable(false);
		btFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btFornecedor.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btFornecedor.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/fornecedor-foco.png"))); // NOI18N
		btFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btFornecedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miFornecedorActionPerformed(evt);
			}
		});
		toolBar.add(btFornecedor);

		btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/sair.png"))); // NOI18N
		btSair.setText("Sair");
		btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btSair.setFocusable(false);
		btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btSair.setMargin(new java.awt.Insets(2, 12, 2, 12));
		btSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/sair-foco.png"))); // NOI18N
		btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miSairActionPerformed(evt);
			}
		});
		toolBar.add(btSair);

		getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

		desktopPane.setOpaque(false);
		getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);
		
		lblBemvindo = new JLabel("Bem-Vindo:");
		lblBemvindo.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.setLayer(lblBemvindo, 0);
		lblBemvindo.setBounds(10, 554, 72, 14);
		desktopPane.add(lblBemvindo);
		
		lblSeulogin = new JLabel("");
		lblSeulogin.setForeground(Color.RED);
		lblSeulogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeulogin.setBounds(92, 555, 331, 14);
		desktopPane.add(lblSeulogin);

		menuCadastros.setText("Cadastros");

		miProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
		miProduto.setText("Cadastrar Produto");
		miProduto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miProdutoActionPerformed(evt);
			}
		});
		menuCadastros.add(miProduto);

		miCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
		miCliente.setText("Cadastrar Cliente");
		miCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miClienteActionPerformed(evt);
			}
		});
		menuCadastros.add(miCliente);

		miFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
		miFornecedor.setText("Cadastrar Fornecedor");
		miFornecedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miFornecedorActionPerformed(evt);
			}
		});
		menuCadastros.add(miFornecedor);

		miFarmceutico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
		miFarmceutico.setText("Cadastrar Funcion�rio");
		miFarmceutico.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miFarmceuticoActionPerformed(evt);
			}
		});
		menuCadastros.add(miFarmceutico);

		miDoenca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
		miDoenca.setText("Registrar Doen�a");
		miDoenca.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miDoencaActionPerformed(evt);
			}
		});
		menuCadastros.add(miDoenca);

		menuBar.add(menuCadastros);

		menuMovimentos.setText("Movimentos");

		miVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
		miVenda.setText("Registrar Venda");
		miVenda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miVendaActionPerformed(evt);
			}
		});
		menuMovimentos.add(miVenda);

		miCompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
		miCompra.setText("Registrar Compra");
		miCompra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miCompraActionPerformed(evt);
			}
		});
		menuMovimentos.add(miCompra);

		menuBar.add(menuMovimentos);

		menuSistema.setText("Sistema");

		miSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		miSobre.setText("Sobre");
		miSobre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miSobreActionPerformed(evt);
			}
		});
		menuSistema.add(miSobre);

		miSair.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
		miSair.setText("Sair");
		miSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miSairActionPerformed(evt);
			}
		});
		menuSistema.add(miSair);

		menuBar.add(menuSistema);

		setJMenuBar(menuBar);

		setSize(new java.awt.Dimension(900, 700));
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void HabilitaItensMenuGerente(boolean ativo) {
		btVenda.setEnabled(!ativo);
		btCompra.setEnabled(ativo);
		btProduto.setEnabled(ativo);
		btCliente.setEnabled(!ativo);
		btFornecedor.setEnabled(ativo);
		miFarmceutico.setEnabled(ativo);
		miProduto.setEnabled(!ativo);
		miCliente.setEnabled(!ativo);
		miFornecedor.setEnabled(ativo);
		miVenda.setEnabled(!ativo);
		miCompra.setEnabled(ativo);
	}

	private void HabilitaItensMenuAtendente(boolean ativo) {
		btVenda.setEnabled(ativo);
		btCompra.setEnabled(!ativo);
		btProduto.setEnabled(!ativo);
		btCliente.setEnabled(ativo);
		btFornecedor.setEnabled(!ativo);
		miFarmceutico.setEnabled(!ativo);
		miProduto.setEnabled(!ativo);
		miCliente.setEnabled(ativo);
		miFornecedor.setEnabled(!ativo);
		miVenda.setEnabled(ativo);
		miCompra.setEnabled(!ativo);
	}

	private void HabilitaItensMenuEstoquista(boolean ativo) {
		btVenda.setEnabled(!ativo);
		btCompra.setEnabled(ativo);
		btProduto.setEnabled(ativo);
		btCliente.setEnabled(!ativo);
		btFornecedor.setEnabled(ativo);
		miFarmceutico.setEnabled(!ativo);
		miProduto.setEnabled(ativo);
		miCliente.setEnabled(!ativo);
		miFornecedor.setEnabled(ativo);
		miVenda.setEnabled(!ativo);
		miCompra.setEnabled(ativo);
	}

	private void miProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miProdutoActionPerformed
		CadastroProduto c = new CadastroProduto();
		desktopPane.add(c);
		c.setVisible(true);
	}// GEN-LAST:event_miProdutoActionPerformed

	private void miClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miClienteActionPerformed
		CadastroCliente c = new CadastroCliente();
		desktopPane.add(c);
		c.setVisible(true);
	}// GEN-LAST:event_miClienteActionPerformed

	private void miFornecedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miFornecedorActionPerformed
		CadastroFornecedor c = new CadastroFornecedor();
		desktopPane.add(c);
		c.setVisible(true);
	}// GEN-LAST:event_miFornecedorActionPerformed

	private void miFarmceuticoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miClienteActionPerformed
		CadastroFarmaceutico farm = new CadastroFarmaceutico();
		desktopPane.add(farm);
		farm.setVisible(true);
	}// GEN-LAST:event_miClienteActionPerformed

	private void miDoencaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miClienteActionPerformed
		CadastroDoenca doenca = new CadastroDoenca();
		desktopPane.add(doenca);
		doenca.setVisible(true);
	}// GEN-LAST:event_miClienteActionPerformed

	private void miVendaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miVendaActionPerformed
		LancamentoVenda v = new LancamentoVenda();
		desktopPane.add(v);
		v.setVisible(true);
	}// GEN-LAST:event_miVendaActionPerformed

	private void miCompraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miCompraActionPerformed
		LancamentoCompra c = new LancamentoCompra();
		desktopPane.add(c);
		c.setVisible(true);
	}// GEN-LAST:event_miCompraActionPerformed

	private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miSobreActionPerformed
		Sobre s = new Sobre(this, true);
		s.setVisible(true);
	}// GEN-LAST:event_miSobreActionPerformed

	private void miSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miSairActionPerformed
		System.exit(0);
	}// GEN-LAST:event_miSairActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btCliente;
	private javax.swing.JButton btCompra;
	private javax.swing.JButton btFornecedor;
	private javax.swing.JButton btProduto;
	private javax.swing.JButton btSair;
	private javax.swing.JButton btVenda;
	private javax.swing.JDesktopPane desktopPane;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenu menuCadastros;
	private javax.swing.JMenu menuMovimentos;
	private javax.swing.JMenu menuSistema;
	private javax.swing.JMenuItem miCliente;
	private javax.swing.JMenuItem miFarmceutico;
	private javax.swing.JMenuItem miDoenca;
	private javax.swing.JMenuItem miCompra;
	private javax.swing.JMenuItem miFornecedor;
	private javax.swing.JMenuItem miProduto;
	private javax.swing.JMenuItem miSair;
	private javax.swing.JMenuItem miSobre;
	private javax.swing.JMenuItem miVenda;
	private javax.swing.JToolBar toolBar;
	private JLabel lblBemvindo;
	private JLabel lblSeulogin;
}
