package com.farma.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.farma.bean.Cliente;
import com.farma.bean.Doencas;
import com.farma.conn.ConnectionFactory;

/**
 * Classe de acesso a dados do cliente
 *
 * @author Inocencio
 */
public class ClienteDAO2 implements IDAO<Cliente> {
	
	@Override
	public void inserir(Cliente cliente) throws Exception {
		if (!cliente.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "INSERT INTO TBCLIENTE (NOME, CPF, DATANASCIMENTO) VALUES (?, ?, ?)";
				pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// pstm.setInt(1, cliente.getDoencas().getCodigo());
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getCpf().toString());
				pstm.setDate(3, new Date(cliente.getDataNascimento().getTime()));
				pstm.execute();

				ResultSet rs = pstm.getGeneratedKeys();
				rs.next();
				int idCliente = rs.getInt(1);

				for (Doencas d : cliente.getListDoencas()) {
					sql = "INSERT INTO TBDOENCAS (NOME, CODIGOCLIENTE) VALUES (?, ?)";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, d.getNome());
					pstm.setInt(2, idCliente);
					pstm.execute();
				}

				JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente no banco de " + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O registro de Cliente enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public void alterar(Cliente cliente) throws Exception {
		if (!cliente.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "UPDATE TBCLIENTE SET NOME=?, CPF=?, DATANASCIMENTO=? WHERE CODCLIENTE=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getCpf());
				pstm.setDate(3, new Date(cliente.getDataNascimento().getTime()));
				pstm.setInt(4, cliente.getCodigo());
				pstm.execute();

				for (Doencas d : cliente.getListDoencas()) {
					if (d.getCodigo() == 0) {
						sql = "INSERT INTO TBDOENCAS (NOME=?, CODIGOCLIENTE=?) VALUES (?, ?)";
						pstm = conn.prepareStatement(sql);
						pstm.setString(1, d.getNome());
						pstm.setInt(2, d.getCliente().getCodigo());
						pstm.execute();
					} else {
						sql = "UPDATE TBDOENCAS SET NOME, CODIGOCLIENTE WHERE CODDOENCAS=?";
						pstm = conn.prepareStatement(sql);
						pstm.setString(1, d.getNome());
						pstm.setInt(2, d.getCliente().getCodigo());
						pstm.setInt(3, d.getCodigo());
						pstm.execute();
					}
				}

				JOptionPane.showMessageDialog(null, "Cadastro de cliente alterado!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente no banco de dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			JOptionPane.showMessageDialog(null, "O registro do cliente enviado por parámetro está vazio");
		}

	}

	@Override
	public void excluir(Cliente cliente) throws Exception {
		if (!cliente.equals(null)) {
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.getConexao();
				String sql = "DELETE FROM TBCLIENTE WHERE CODCLIENTE=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, cliente.getCodigo());
				ps.execute();
				JOptionPane.showMessageDialog(null, "Cliente removido!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir cliente no banco de" + "dados " + e.getMessage());
				e.printStackTrace();
			} finally {
				ConnectionFactory.fechaConexao(conn, pstm);
			}
		} else {
			System.out.println("O id do cliente enviado por parámetro está vazio");
			return;
		}
	}

	@Override
	public ArrayList<Cliente> listarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ClienteDAO2 clienteDAO = new ClienteDAO2();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBCLIENTE ORDER BY NOME";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("CODCLIENTE"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setDataNascimento(rs.getDate("DATANASCIMENTO"));

				String sqlDoenca = "SELECT *FROM TBDOENCAS WHERE CODIGOCLIENTE = ?";
				PreparedStatement psDoenca = conn.prepareStatement(sqlDoenca);
				psDoenca.setInt(1, cliente.getCodigo());
				ResultSet rsDoenca = psDoenca.executeQuery();

				while (rsDoenca.next()) {
					Doencas d = new Doencas();
					d.setCodigo(rsDoenca.getInt("CODDOENCAS"));
					d.setNome(rsDoenca.getString("NOME"));
					d.setCliente(clienteDAO.recuperar(rsDoenca.getInt("CODIGOCLIENTE")));
					cliente.addDoenca(d);
				}
				listaClientes.add(cliente);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar clientes! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return listaClientes;
	}

	@Override
	public Cliente recuperar(int codigo) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Cliente cliente = new Cliente();
		try {
			conn = ConnectionFactory.getConexao();
			String sql = "SELECT * FROM TBCLIENTE WHERE CODCLIENTE=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			if (rs.next()) {
				cliente.setCodigo(rs.getInt("CODCLIENTE"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setDataNascimento(rs.getDate("DATANASCIMENTO"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar cliente! " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		}
		return cliente;
	}

	@Override
	public ArrayList<Cliente> recuperarDoencasPorCliente(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
