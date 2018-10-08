package com.farma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.farma.bean.Fornecedor;
import com.farma.conn.ConnectionFactory;

/**
 * Classe de acesso a dados do fornecedor
 *
 * @author Inocencio
 */
public class FornecedorDAO implements IDAO<Fornecedor> {

	@Override
	public void inserir(Fornecedor fornecedor) throws Exception {
		if (!fornecedor.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO TBFORNECEDOR (NOME, CNPJ) VALUES (?, ?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, fornecedor.getNome());
				pstm.setString(2, fornecedor.getCnpj());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Fornecedor cadastrado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir Fornecedor no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de fornecedor enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Fornecedor fornecedor) throws Exception {
		if (!fornecedor.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBFORNECEDOR SET NOME=?, CNPJ=? WHERE CODFORNECEDOR=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, fornecedor.getNome());
				pstm.setString(2, fornecedor.getCnpj());
				pstm.setInt(3, fornecedor.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Fornecedor alterado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao alterar Fornecedor no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de fornecedor enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void excluir(Fornecedor fornecedor) throws Exception {
		if (!fornecedor.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "DELETE FROM TBFORNECEDOR WHERE CODFORNECEDOR=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, fornecedor.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Fornecedor excluído!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao excluir fornecedor no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro do fornecedor enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public ArrayList<Fornecedor> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TBFORNECEDOR ORDER BY NOME";
		ArrayList<Fornecedor> listaFornecedors = new ArrayList<Fornecedor>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCodigo(rs.getInt("CODFORNECEDOR"));
				fornecedor.setNome(rs.getString("NOME"));
				fornecedor.setCnpj(rs.getString("CNPJ"));
				listaFornecedors.add(fornecedor);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar fornecedor! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaFornecedors;
	}

	@Override
	public Fornecedor recuperar(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Fornecedor fornecedor = new Fornecedor();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBFORNECEDOR WHERE CODFORNECEDOR=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			if (rs.next()) {
				fornecedor.setCodigo(rs.getInt("CODFORNECEDOR"));
				fornecedor.setNome(rs.getString("NOME"));
				fornecedor.setCnpj(rs.getString("CNPJ"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar fornecedor! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}

		return fornecedor;
	}

	@Override
	public ArrayList<Fornecedor> recuperarDoencasPorCliente(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
