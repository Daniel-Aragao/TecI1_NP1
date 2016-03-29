package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Estado;
import domain.interfaces.IRepositorio;

public class RepositorioEstado implements IRepositorio<Estado>{

	@Override
	public boolean adicionar(Estado elemento) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Estado get(int EstadoId) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Estado estado = null;
		
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM estado WHERE Id = ?");
			stmt.setInt(1, EstadoId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String uf = rs.getString("uf"); 
				
				estado = new Estado(id, nome, uf);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

		return estado;
	}

	@Override
	public ArrayList<Estado> getAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Estado> estados = new ArrayList<Estado>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM estado");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String uf = rs.getString("uf"); 
				
				Estado estado = new Estado(id, nome, uf);
				estados.add(estado);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

		return estados;
	}

	@Override
	public ArrayList<Estado> getList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

}
