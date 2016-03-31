package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import domain.entitys.Movimentacao;
import domain.interfaces.IRepositorio;

public class RepositorioMovimentacao implements IRepositorio<Movimentacao>{

	@Override
	public boolean adicionar(Movimentacao mov) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"INSERT INTO movimentacao(descricao, objeto_numero, posto_id, data_hora) VALUES (?,?,?,?)");

			stmt.setString(1, mov.getDescricao());
			stmt.setString(2, mov.getObjeto_numero());
			stmt.setInt(3, mov.getPosto_id());
			stmt.setTimestamp(4, mov.getData_hora());

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
	public Movimentacao get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Movimentacao> getList(String param) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM movimentacao WHERE  objeto_numero LIKE ?");
			stmt.setString(1, "%"+param+"%");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				String objeto_numero = rs.getString("objeto_numero");
				int postoId = rs.getInt("posto_id");
				Timestamp data_hora = rs.getTimestamp("data_hora");
				

				Movimentacao movimentacao = new Movimentacao(id, descricao, objeto_numero,postoId, data_hora);
				movimentacoes.add(movimentacao);
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

		return movimentacoes;
	}

	@Override
	public ArrayList<Movimentacao> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Movimentacao elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeElement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
