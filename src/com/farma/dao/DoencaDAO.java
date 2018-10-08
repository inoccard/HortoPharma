package com.farma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.farma.bean.Doencas;
import com.farma.conn.ConnectionFactory;

public class DoencaDAO implements IDAO<Doencas> {

	@Override
	public void inserir(Doencas doenca) throws Exception {
		if (!doenca.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO TBDOENCAS (NOME, CODIGOCLIENTE) VALUES (?, ?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, doenca.getNome());
				pstm.setInt(2, doenca.getCliente().getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Doença cadastrada!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao cadastrar doença no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de doença enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Doencas doenca) throws Exception {
		if (!doenca.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBDOENCAS SET NOME=?, CODIGOCLIENTE=? WHERE CODDOENCAS = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, doenca.getNome());
				pstm.setInt(2, doenca.getCliente().getCodigo());
				pstm.setInt(3, doenca.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Cadastro de Doença alterado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao alterar doença no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de doença enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void excluir(Doencas doenca) throws Exception {

	}

	@Override
	public ArrayList<Doencas> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TBDOENCAS ORDER BY CODIGOCLIENTE ASC";
		ArrayList<Doencas> listaDoencas = new ArrayList<Doencas>();
		ClienteDAO2 clienteDAO = new ClienteDAO2();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Doencas doenca = new Doencas();
				doenca.setCodigo(rs.getInt("CODDOENCAS"));
				doenca.setNome(rs.getString("NOME"));
				doenca.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
				listaDoencas.add(doenca);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Doenças! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaDoencas;
	}

	@Override
	public ArrayList<Doencas> recuperarDoencasPorCliente(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ClienteDAO2 clienteDAO = new ClienteDAO2();
		ArrayList<Doencas> listaDoencas = new ArrayList<Doencas>();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBDOENCAS WHERE CODIGOCLIENTE = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Doencas doenca = new Doencas();
				doenca.setCodigo(rs.getInt("CODDOENCAS"));
				doenca.setNome(rs.getString("NOME"));
				doenca.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
				listaDoencas.add(doenca);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar Doenças! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaDoencas;
	}

	@Override
	public Doencas recuperar(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
