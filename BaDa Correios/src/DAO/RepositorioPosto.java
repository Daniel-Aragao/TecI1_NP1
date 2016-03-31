package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Posto;
import domain.interfaces.IRepositorio;

public class RepositorioPosto implements IRepositorio<Posto>{

	@Override
	public boolean adicionar(Posto elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Posto get(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Posto posto = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM objeto WHERE  numero = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id2 = rs.getInt("id");
				int cidadeId = rs.getInt("cidadeId");
				String nome = rs.getString("nome"); 
				String endereco = rs.getString("endereco");
				
				posto = new Posto(nome,endereco,id2, cidadeId);
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

		return posto;
	}

	@Override
	public ArrayList<Posto> getList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Posto> getAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Posto> postos = new ArrayList<Posto>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM posto");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				int cidadeId = rs.getInt("cidadeId");
				String nome = rs.getString("nome"); 
				String endereco = rs.getString("endereco");
				
				Posto posto = new Posto(nome,endereco,id, cidadeId);
				postos.add(posto);
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

		return postos;
	}

	@Override
	public boolean alterar(Posto elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeElement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
