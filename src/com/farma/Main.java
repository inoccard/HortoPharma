package com.farma;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.farma.gui.Menu;

/**
 * Classe principal que inicia a aplicação
 *
 * @author Inocencio
 */
public class Main {

    /**
     * Método responsável por iniciar a aplicação
     *
     * @param args lista de parámetros do método main
     */
    public static void main(String[] args) {
        lookAndFeel();
        Menu menu = new Menu();
        menu.setVisible(true);
//       	new Login().setVisible(true);
    }

    private static void lookAndFeel() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
