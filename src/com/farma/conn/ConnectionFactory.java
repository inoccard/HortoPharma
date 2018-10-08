package com.farma.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	//Dados para a conex�o com o banco
		private static final String USUARIO = "root";
		private static final String SENHA = "";

		private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/hortofarmabd";
//		private static final Connection Conexao= getConexao();
		public static Connection getConexao() throws SQLException {

			Connection conn = null;

			try {
				//Falta o jar (Connector) do mysql; eu nao vi na sua pasta lib, so assim ele podera reconhecer o driver inserir
				
				//Class.forName("com.mysql.jdbc.Driver");
				DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(STR_CONEXAO, USUARIO, SENHA);
				System.out.println("Conex�o OK!");
				return conn;
			} catch (SQLException e) {
				throw new SQLException("Erro ao conectar com a base de dados " + e.getMessage());
			}
		}

		public static void fechaConexao(Connection conn) {
			
			try {
				if (conn != null) {
					conn.close();
					System.out.println("Fechada a conex�o com o banco de dados");
				}

			} catch (Exception e) {
				System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados " + e.getMessage());
			}
		}

		public static void fechaConexao(Connection conn, PreparedStatement stmt) {

			try {
				if (conn != null) {
					fechaConexao(conn);
				}
				if (stmt != null) {
					stmt.close();
					System.out.println("PreparedStatement fechado com sucesso");
				}

			} catch (Exception e) {
				System.out.println("N�o foi poss�vel fechar o statement " + e.getMessage());
			}
		}

		public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {

			try {
				if (conn != null || stmt != null) {
					fechaConexao(conn, stmt);
				}
				if (rs != null) {
					rs.close();
					System.out.println("ResultSet fechado com sucesso");
				}


			} catch (Exception e) {
				System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
			}
		}
}
