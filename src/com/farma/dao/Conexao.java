package com.farma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe respons√°vel por abrir a conex√£o com o banco de dados
 *
 * @author Inocencio
 */
public class Conexao {

    private final String USUARIO = "root";
    private final String SENHA = "";
    private final String URL = "jdbc:mysql://localhost:3306/hortofarmabd";

    private Connection conexao;

    public Conexao() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        try {
        	DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conex„o OK ");
			
        } catch (SQLException e) {
            throw new SQLException("Problemas nos par√¢metros de conex√£o.\n" + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void confirmar() throws SQLException {
        try {
            conexao.commit();
        } catch (SQLException e) {
            throw new SQLException("Problemas na instruÁ„o SQL.\n" + e.getMessage());
        } finally {
            conexao.close();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
		new Conexao().getConexao();
	}
}
