package com.farma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.farma.bean.Farmaceutico;
import com.farma.conn.ConnectionFactory;

/**
 * Classe de acesso a dados do farmaceutico
 *
 * @author Inocencio
 */
public class FarmaceuticoDAO implements IDAO<Farmaceutico> {
	private int nivel = -1;

	@Override
	public void inserir(Farmaceutico farmaceutico) throws Exception {
		if (!farmaceutico.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO FARMACEUTICO (LOGIN, SENHA, CARGO, NIVEL_ACESSO) VALUES (?, ?, ?, ?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, farmaceutico.getLogin());
				pstm.setString(2, farmaceutico.getSenha());
				pstm.setString(3, farmaceutico.getCargo());
				pstm.setInt(4, farmaceutico.getNivel());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Farmacéutico cadastrado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir farmacéutio no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de farmaccéutico enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Farmaceutico farmaceutico) throws Exception {
		if (!farmaceutico.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE FARMACEUTICO SET LOGIN=?, SENHA=?, CARGO=?, NIVEL_ACESSO=? WHERE CODFARMACEUTICO = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, farmaceutico.getLogin());
				pstm.setString(2, farmaceutico.getSenha());
				pstm.setString(3, farmaceutico.getCargo());
				pstm.setInt(4, farmaceutico.getNivel());
				pstm.setInt(5, farmaceutico.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Farmacéutico alterado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao alterar farmacéutio no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de farmaccéutico enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void excluir(Farmaceutico farmaceutico) throws Exception {
		if (!farmaceutico.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "DELETE FROM FARMACEUTICO WHERE CODFARMACEUTICO = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, farmaceutico.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Farmacéutico excluído!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao excluir farmacéutio no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O id do farmaccéutico enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public ArrayList<Farmaceutico> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FARMACEUTICO ORDER BY LOGIN";
		ArrayList<Farmaceutico> listaFarmaceuticos = new ArrayList<Farmaceutico>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Farmaceutico farmaceutico = new Farmaceutico();
				farmaceutico.setCodigo(rs.getInt("CODFARMACEUTICO"));
				farmaceutico.setLogin(rs.getString("LOGIN"));
				farmaceutico.setCargo(rs.getString("CARGO"));
				farmaceutico.setNivel(rs.getInt("NIVEL_ACESSO"));
				listaFarmaceuticos.add(farmaceutico);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar farmacéuticos! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaFarmaceuticos;
	}

	@Override
	public Farmaceutico recuperar(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Farmaceutico farmaceutico = new Farmaceutico();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM FARMACEUTICO WHERE CODFARMACEUTICO = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			if (rs.next()) {
				farmaceutico.setCodigo(rs.getInt("CODFARMACEUTICO"));
				farmaceutico.setLogin(rs.getString("LOGIN"));
				farmaceutico.setCargo(rs.getString("CARGO"));
				farmaceutico.setNivel(rs.getInt("NIVEL_ACESSO"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar farmacéuticos! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return farmaceutico;
	}

	public boolean logar(JTextField login, JTextField senha) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Farmaceutico fc = new Farmaceutico();
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM FARMACEUTICO WHERE LOGIN = ? AND SENHA = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, login.getText().trim());
			ps.setString(2, senha.getText().trim());
			rs = ps.executeQuery();

			if (rs.next()) {
				fc.setLogin(rs.getString("LOGIN"));
				fc.setSenha(rs.getString("SENHA"));
				fc.setCargo(rs.getString("CARGO"));
				fc.setNivel(rs.getInt("NIVEL_ACESSO"));
				nivel = fc.getNivel();
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao buscar usuário!\nLogin ou Senha inválido(s)!");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao acessar o sistema.! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return false;
	}

	public int getNivel() {
		return nivel;
	}

	public void consultarStatus(JTextField login, JTextField senha) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConexao();
			Farmaceutico fc = new Farmaceutico();
			String sql = "SELECT * FROM FARMACEUTICO WHERE LOGIN = ? AND SENHA = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login.getText());
			pstm.setString(2, senha.getText());

			rs = pstm.executeQuery();
			rs.next();

			fc.setCodigo((int) rs.getInt("CODFARMACEUTICO"));
			fc.setLogin(rs.getString("LOGIN"));
			fc.setSenha(rs.getString("SENHA"));
			fc.setCargo(rs.getString("CARGO"));
			fc.setNivel(rs.getInt("NIVEL_ACESSO"));
		} catch (SQLException e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Erro ao buscar status!");
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
	}

	@Override
	public ArrayList<Farmaceutico> recuperarDoencasPorCliente(int codigo) throws Exception {
		return null;
	}
}
