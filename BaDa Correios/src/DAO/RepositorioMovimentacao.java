package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
					"INSERT INTO movimentacao(descricao, objeto_numero, posto_id) VALUES (?,?,?)");

			stmt.setString(1, mov.getDescricao());
			stmt.setString(2, mov.getObjeto_numero());
			stmt.setInt(3, mov.getPosto_id());

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
		// TODO Auto-generated method stub
		return null;
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
