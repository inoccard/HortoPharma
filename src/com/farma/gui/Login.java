package com.farma.gui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.farma.bean.Farmaceutico;
import com.farma.dao.FarmaceuticoDAO;
import javax.swing.JPasswordField;

/**
 * Janela de Login
 *
 * @author Inocencio
 */

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		setTitle("Login");
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		lbLogin = new javax.swing.JLabel();
		lbSenha = new javax.swing.JLabel();
		ftfLogin = new javax.swing.JFormattedTextField();
		ftfSenha = new JPasswordField();
		pnConteudo = new javax.swing.JPanel();
		pnForm = new javax.swing.JPanel();
		pnForm.setBounds(10, 109, 328, 115);
		pnForm.setToolTipText("Logar no Sistema");

		pnConteudo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
		setBounds(10, 10, 364, 329);
		pnConteudo.setLayout(null);

		pnForm.setBorder(
				javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0),
						javax.swing.BorderFactory.createTitledBorder(null, "Logar no Sistema",
								javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11),
								new java.awt.Color(102, 153, 255))));
		pnForm.setOpaque(false);
		pnForm.setLayout(new java.awt.GridBagLayout());

		lbLogin.setText("Login:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbLogin, gridBagConstraints);

		lbSenha.setText("Senha:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(lbSenha, gridBagConstraints);
		pnConteudo.add(pnForm);

		ftfLogin.setColumns(27);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfLogin, gridBagConstraints);

		ftfSenha.setColumns(27);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnForm.add(ftfSenha, gridBagConstraints);

		getContentPane().add(pnConteudo, java.awt.BorderLayout.CENTER);

		JButton btnEntrar = new JButton();
		btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/buscar.png")));
		btnEntrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEntrar.setText("Entrar");
		btnEntrar.setMargin(new Insets(2, 8, 2, 8));
		btnEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEntrar.setFocusable(false);
		btnEntrar.setBounds(84, 240, 94, 43);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					btnEntrarActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		pnConteudo.add(btnEntrar);

		JButton btnCancelar = new JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});
		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farma/gui/img/cancelar.png")));
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setText("Cancelar");
		btnCancelar.setMargin(new Insets(2, 8, 2, 8));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setFocusable(false);
		btnCancelar.setBounds(210, 240, 94, 43);
		pnConteudo.add(btnCancelar);

		JPanel pnImagem = new JPanel();
		pnImagem.setBorder(new BevelBorder(BevelBorder.RAISED, Color.PINK, null, null, null));
		pnImagem.setBounds(1, 0, 346, 108);
		pnConteudo.add(pnImagem);

	}

	private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		FarmaceuticoDAO farmaceutico = new FarmaceuticoDAO();

		if (farmaceutico.logar(ftfLogin, ftfSenha)) {
			new Menu(farmaceutico.getNivel(),ftfLogin.getText()).setVisible(true);
			dispose();
		}
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(JFrame.EXIT_ON_CLOSE);
	}

	private javax.swing.JLabel lbLogin;
	private javax.swing.JLabel lbSenha;
	private javax.swing.JFormattedTextField ftfLogin;
	private JPasswordField ftfSenha;
	private javax.swing.JPanel pnForm;
	private javax.swing.JPanel pnConteudo;
}
