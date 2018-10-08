package com.farma.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.farma.bean.ItemVenda;
import com.farma.bean.Produto;
import com.farma.bean.Venda;
import com.farma.bean.enums.Situacao;
import com.farma.conn.ConnectionFactory;

/**
 * Classe de acesso a dados da venda
 *
 * @author Inocencio
 */
public class VendaDAO implements IDAO<Venda> {

	@Override
	public void inserir(Venda venda) throws Exception {
		if (!venda.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO TBVENDA (CODIGOCLIENTE, DATAVENDA, VALORTOTAL, SITUACAO) VALUES (?, ?, ?, ?)";
				pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstm.setInt(1, venda.getCliente().getCodigo());
				pstm.setDate(2, new Date(venda.getDataVenda().getTime()));
				pstm.setDouble(3, venda.getValorTotal());
				pstm.setInt(4, venda.getSituacao().getId());
				pstm.execute();

				ResultSet rs = pstm.getGeneratedKeys();
				rs.next();
				int idVenda = rs.getInt(1);

				for (ItemVenda iv : venda.getItens()) {
					sql = "INSERT INTO TBITEMVENDA (CODIGOPRODUTO, CODIGOVENDA, QUANTIDADE, VALORUNITARIO, DESCONTO, PAGAR) VALUES (?, ?, ?, ?, ?, ?)";
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, iv.getProduto().getCodigo());
					pstm.setInt(2, idVenda);
					pstm.setInt(3, iv.getQuantidade());
					pstm.setDouble(4, iv.getValorUnitario());
					pstm.setDouble(5, iv.getDesconto());
					pstm.setDouble(6, iv.getPagar());
					pstm.execute();

					if (venda.getSituacao() == Situacao.FINALIZADA) {
						ProdutoDAO produtoDAO = new ProdutoDAO();
						produtoDAO.saidaEstoque(iv.getProduto().getCodigo(), iv.getQuantidade());
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de venda enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Venda venda) throws Exception {
		if (!venda.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBVENDA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, SITUACAO=? WHERE CODVENDAS=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, venda.getCliente().getCodigo());
				pstm.setDate(2, new Date(venda.getDataVenda().getTime()));
				pstm.setDouble(3, venda.getValorTotal());
				pstm.setInt(4, venda.getSituacao().getId());
				pstm.setInt(5, venda.getCodigo());
				pstm.execute();

				for (ItemVenda iv : venda.getItensRemover()) {
					sql = "DELETE FROM TBITEMVENDA WHERE CODIGO=?";
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, iv.getCodigo());
					pstm.execute();
				}

				for (ItemVenda iv : venda.getItens()) {
					if (iv.getCodigo() == 0) {
						sql = "INSERT INTO TBITEMVENDA (CODIGOPRODUTO, CODIGOVENDA, QUANTIDADE, VALORUNITARIO, DESCONTO, PAGAR) VALUES (?, ?, ?, ?, ?, ?)";
						pstm = conn.prepareStatement(sql);
						pstm.setInt(1, iv.getProduto().getCodigo());
						pstm.setInt(2, iv.getVenda().getCodigo());
						pstm.setInt(3, iv.getQuantidade());
						pstm.setDouble(4, iv.getValorUnitario());
						pstm.setDouble(5, iv.getDesconto());
						pstm.setDouble(6, iv.getPagar());
						pstm.execute();
					} else {
						sql = "UPDATE TBITEMVENDA SET CODIGOPRODUTO=?, CODIGOVENDA=?, QUANTIDADE=?, VALORUNITARIO=?, DESCONTO=?, PAGAR=? WHERE CODIGOVENDA=?";
						pstm = conn.prepareStatement(sql);
						pstm.setInt(1, iv.getProduto().getCodigo());
						pstm.setInt(2, iv.getVenda().getCodigo());
						pstm.setInt(3, iv.getQuantidade());
						pstm.setDouble(4, iv.getValorUnitario());
						pstm.setDouble(5, iv.getDesconto());
						pstm.setDouble(6, iv.getPagar());
						pstm.setInt(7, iv.getCodigo());
						pstm.execute();
					}
					if (venda.getSituacao() == Situacao.FINALIZADA) {
						ProdutoDAO produtoDAO = new ProdutoDAO();
						produtoDAO.saidaEstoque(iv.getProduto().getCodigo(), iv.getQuantidade());
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao alterar venda no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de venda enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void excluir(Venda venda) throws Exception {
		if (!venda.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBVENDA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, SITUACAO=? WHERE CODVENDAS=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, venda.getCliente().getCodigo());
				pstm.setDate(2, new Date(venda.getDataVenda().getTime()));
				pstm.setDouble(3, venda.getValorTotal());
				pstm.setInt(4, Situacao.CANCELADA.getId());
				pstm.setInt(5, venda.getCodigo());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "venda excluída!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir venda no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O id da venda enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public ArrayList<Venda> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Venda> listaVendas = new ArrayList<Venda>();
		ClienteDAO2 clienteDAO = new ClienteDAO2();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBVENDA ORDER BY DATAVENDA DESC";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Venda venda = new Venda();
				venda.setCodigo(rs.getInt("CODVENDAS"));
				venda.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
				venda.setDataVenda(rs.getDate("DATAVENDA"));
				venda.setSituacao(rs.getInt("SITUACAO"));

				String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
				PreparedStatement psItem = conn.prepareStatement(sqlItem);
				psItem.setInt(1, venda.getCodigo());
				ResultSet rsItem = psItem.executeQuery();

				while (rsItem.next()) {
					ItemVenda iv = new ItemVenda();
					iv.setCodigo(rsItem.getInt("CODIGO"));
					iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
					iv.setVenda(venda);
					iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
					iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
					iv.setDesconto(rsItem.getDouble("DESCONTO"));
					iv.setPagar(rsItem.getDouble("PAGAR"));
					venda.addItem(iv);
				}
				listaVendas.add(venda);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar venda! " + e.getMessage());
			e.printStackTrace();

		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaVendas;
	}

	@Override
	public Venda recuperar(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ClienteDAO2 clienteDAO = new ClienteDAO2();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Venda venda = new Venda();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBVENDA WHERE CODIGOCLIENTE = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			if (rs.next()) {
				venda.setCodigo(rs.getInt("CODVENDAS"));
				venda.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
				venda.setDataVenda(rs.getDate("DATAVENDA"));
				venda.setSituacao(rs.getInt("SITUACAO"));

				String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
				PreparedStatement psItem = conn.prepareStatement(sqlItem);
				psItem.setInt(1, venda.getCodigo());
				ResultSet rsItem = psItem.executeQuery();

				while (rsItem.next()) {
					ItemVenda iv = new ItemVenda();
					iv.setCodigo(rsItem.getInt("CODIGO"));
					iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
					iv.setVenda(venda);
					iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
					iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
					iv.setDesconto(rsItem.getDouble("DESCONTO"));
					iv.setPagar(rsItem.getDouble("PAGAR"));
					venda.addItem(iv);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar o venda! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return venda;
	}

	public ItemVenda recuperar(Venda venda, Produto produto) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ItemVenda iv = null;
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBITEMVENDA WHERE CODIGOPRODUTO = ? AND CODIGOVENDA = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, produto.getCodigo());
			pstm.setInt(2, venda.getCodigo());
			rs = pstm.executeQuery();
			while (rs.next()) {
				iv = new ItemVenda();
				iv.setCodigo(rs.getInt("CODIGO"));
				iv.setProduto(produto);
				iv.setVenda(venda);
				iv.setQuantidade(rs.getInt("QUANTIDADE"));
				iv.setValorUnitario(rs.getDouble("VALORUNITARIO"));
				iv.setDesconto(rs.getDouble("DESCONTO"));
				iv.setPagar(rs.getDouble("PAGAR"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar o venda! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return iv;
	}

	@Override
	public ArrayList<Venda> recuperarDoencasPorCliente(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
