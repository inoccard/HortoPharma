package com.farma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.farma.bean.Produto;
import com.farma.conn.ConnectionFactory;

/**
 * Classe de acesso a dados do produto
 *
 * @author Inocencio
 */
public class ProdutoDAO implements IDAO<Produto> {
	@Override
	public void inserir(Produto produto) throws Exception {
		if (!produto.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO TBPRODUTO (NOME, PRECOCOMPRA, PRECOVENDA, QTDESTOQUE, CLASSE, DESCONTO) VALUES (?, ?, ?, 0, ?, ?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, produto.getNome());
				pstm.setDouble(2, produto.getPrecoCompra());
				pstm.setDouble(3, produto.getPrecoVenda());
				pstm.setInt(4, produto.getClasse().getId());
				pstm.setDouble(5, produto.getDesconto());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Produto cadastrado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir Produto no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de Produto enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Produto produto) throws Exception {
		if (!produto.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBPRODUTO SET NOME=?, PRECOCOMPRA=?, PRECOVENDA=?, CLASSE=?, DESCONTO=? WHERE CODPRODUTO=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, produto.getNome());
				pstm.setDouble(2, produto.getPrecoCompra());
				pstm.setDouble(3, produto.getPrecoVenda());
				pstm.setInt(4, produto.getClasse().getId());
				pstm.setDouble(5, produto.getDesconto());
				pstm.setInt(6, produto.getCodigo());
				
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Produto alterado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao alterar Produto no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de Produto enviado por parámetro está vazio");
			return;
		}
	}

	public void entradaEstoque(int codigo, int quantidade) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE TBPRODUTO SET QTDESTOQUE = QTDESTOQUE  + ? WHERE CODPRODUTO=?";
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, quantidade);
			pstm.setInt(2, codigo);
			pstm.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao registrar entrada de estoque! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm);
		}
	}

	public void saidaEstoque(int codigo, int quantidade) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE TBPRODUTO SET QTDESTOQUE = QTDESTOQUE  - ? WHERE CODPRODUTO=?";
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, quantidade);
			pstm.setInt(2, codigo);
			pstm.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao registrar saída de estoque! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm);
		}
	}

	@Override
	public void excluir(Produto produto) throws Exception {
		if (!produto.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "DELETE FROM TBPRODUTO WHERE CODPRODUTO=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, produto.getCodigo());
				ps.execute();
				JOptionPane.showMessageDialog(null, "Produto excluído!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir Produto no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O id do Produto enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public ArrayList<Produto> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TBPRODUTO ORDER BY NOME ASC";
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("CODPRODUTO"));
				produto.setNome(rs.getString("NOME"));
				produto.setPrecoCompra(rs.getDouble("PRECOCOMPRA"));
				produto.setPrecoVenda(rs.getDouble("PRECOVENDA"));
				produto.setQuantidade(rs.getInt("QTDESTOQUE"));
				produto.setClasse((Integer) rs.getInt("CLASSE"));
				produto.setDesconto(rs.getDouble("DESCONTO"));
				listaProdutos.add(produto);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar produtos! " + e.getMessage());
			e.printStackTrace();

		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaProdutos;
	}

	@Override
	public Produto recuperar(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Produto produto = new Produto();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBPRODUTO WHERE CODPRODUTO=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			if (rs.next()) {
				produto.setCodigo(rs.getInt("CODPRODUTO"));
				produto.setNome(rs.getString("NOME"));
				produto.setPrecoCompra(rs.getDouble("PRECOCOMPRA"));
				produto.setPrecoVenda(rs.getDouble("PRECOVENDA"));
				produto.setQuantidade(rs.getInt("QTDESTOQUE"));
				produto.setClasse(rs.getInt("CLASSE"));
				produto.setDesconto(rs.getDouble("DESCONTO"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar o produto! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return produto;
	}

	@Override
	public ArrayList<Produto> recuperarDoencasPorCliente(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
