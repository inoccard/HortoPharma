package com.farma;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.farma.gui.Menu;

/**
 * Classe principal que inicia a aplica��o
 *
 * @author Inocencio
 */
public class Main {

    /**
     * M�todo respons�vel por iniciar a aplica��o
     *
     * @param args lista de par�metros do m�todo main
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
