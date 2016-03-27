package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Cidade;
import domain.entitys.Estado;
import domain.interfaces.IRepositorio;

public class RepositorioCidade implements IRepositorio<Cidade>{

	@Override
	public void adicionar(Cidade elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cidade get(int CidadeId) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Cidade cidade = null;
		
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM cidade WHERE Id = ?");
			stmt.setInt(1, CidadeId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				int estadoId = rs.getInt("estadoId");
				String nome = rs.getString("nome"); 
				
				cidade = new Cidade(id, estadoId, nome);
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

		return cidade;
	}

	@Override
	public ArrayList<Cidade> getAll() {
		return null;
	}

	@Override
	public ArrayList<Cidade> getList(String EstadoId) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Cidade> cidades = new ArrayList<Cidade>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM cidade WHERE estadoId = ?");
			stmt.setInt(1, Integer.parseInt(EstadoId));
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				int estadoId = rs.getInt("estadoId");
				String nome = rs.getString("nome"); 
				
				Cidade cidade = new Cidade(id, estadoId, nome);
				cidades.add(cidade);
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

		return cidades;
	}

}
