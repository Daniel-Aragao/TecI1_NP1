package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Pessoa;
import domain.interfaces.IRepositorio;

public class RepositorioPessoa implements IRepositorio<Pessoa>{

	@Override
	public boolean adicionar(Pessoa pessoa) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into pessoa (nome, rua, numero, complemento, bairro, cep, cidadeId, paisId, estadoId) values(?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getRua());
			stmt.setInt(3, pessoa.getNumero());
			stmt.setString(4, pessoa.getComplemento());
			stmt.setString(5, pessoa.getBairro());
			stmt.setString(6, pessoa.getCep());
			stmt.setInt(7, pessoa.getCidadeId());
			stmt.setInt(8, 1);
			stmt.setInt(9, pessoa.getEstadoId());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		
	}

	@Override
	public Pessoa get(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Pessoa pessoa = null;
		
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM pessoa WHERE  id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				String nome = rs.getString("nome");
				String rua = rs.getString("rua"); 
				String complemento = rs.getString("complemento"); 
				String bairro = rs.getString("bairro"); 
				String cep = rs.getString("cep"); 
				int estadoId = rs.getInt("estadoId");
				int cidadeId = rs.getInt("cidadeId");
				int numero = rs.getInt("numero");

				pessoa = new Pessoa(id, nome, rua, complemento, 
						 bairro, cep, estadoId, cidadeId, numero);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pessoa;
	}

	@Override
	public ArrayList<Pessoa> getList(String param) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM pessoa WHERE  nome LIKE ?");
			stmt.setString(1, "%"+param+"%");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String rua = rs.getString("rua"); 
				String complemento = rs.getString("complemento"); 
				String bairro = rs.getString("bairro"); 
				String cep = rs.getString("cep"); 
				int estadoId = rs.getInt("estadoId");
				int cidadeId = rs.getInt("cidadeId");
				int numero = rs.getInt("numero");

				Pessoa pessoa = new Pessoa(id, nome, rua, complemento, 
						 bairro, cep, estadoId, cidadeId, numero);
				pessoas.add(pessoa);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> getAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM pessoa");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String rua = rs.getString("rua"); 
				String complemento = rs.getString("complemento"); 
				String bairro = rs.getString("bairro"); 
				String cep = rs.getString("cep"); 
				int estadoId = rs.getInt("estadoId");
				int cidadeId = rs.getInt("cidadeId");
				int numero = rs.getInt("numero");

				Pessoa pessoa = new Pessoa(id, nome, rua, complemento, 
						 bairro, cep, estadoId, cidadeId, numero);
				pessoas.add(pessoa);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pessoas;
	}

	@Override
	public boolean alterar(Pessoa pessoa) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"UPDATE pessoa SET nome = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidadeId = ?, estadoId =? WHERE id = ?");

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getRua());
			stmt.setInt(3, pessoa.getNumero());
			stmt.setString(4, pessoa.getComplemento());
			stmt.setString(5, pessoa.getBairro());
			stmt.setString(6, pessoa.getCep());
			stmt.setInt(7, pessoa.getCidadeId());
			stmt.setInt(8, pessoa.getEstadoId());
			stmt.setInt(9, pessoa.getId());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}

	@Override
	public boolean removeElement(int id) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"DELETE FROM pessoa WHERE id = ?");

			stmt.setInt(1, id);
			

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		
	}
	
}
