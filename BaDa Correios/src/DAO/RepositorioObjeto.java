package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Objeto;
import domain.interfaces.IRepositorio;

public class RepositorioObjeto implements IRepositorio<Objeto>{

	public boolean adicionar(Objeto objeto) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into objeto (numero, descricao, peso, altura, largura, profundidade, valor, remetente_id, destinatario_id) values(?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, objeto.getNumero());
			stmt.setString(2, objeto.getDescricao());
			stmt.setDouble(3, objeto.getPeso());
			stmt.setDouble(4, objeto.getAltura());
			stmt.setDouble(5, objeto.getLargura());
			stmt.setDouble(6, objeto.getProfundidade());
			stmt.setDouble(7, objeto.getValor());
			stmt.setInt(8, objeto.getRemetendeId());
			stmt.setInt(9, objeto.getDestinatarioId());

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
	public Objeto get(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Objeto objeto = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM objeto WHERE  numero = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				String numero = rs.getString("numero");
				String descricao = rs.getString("descricao");
				double peso = rs.getDouble("peso");
				double altura = rs.getDouble("altura");
				double largura = rs.getDouble("largura");
				double profundidade = rs.getDouble("profundidade");
				double valor = rs.getDouble("valor");
				int remetendeId = rs.getInt("remetente_Id");
				int destinatarioId = rs.getInt("destinatario_Id");
				
				
				objeto = new Objeto(numero, descricao, peso, altura, largura, profundidade,
						valor, remetendeId, destinatarioId);
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

		return objeto;
	}

	@Override
	public ArrayList<Objeto> getAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Objeto> objeto = new ArrayList<Objeto>();
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM objeto");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				String descricao = rs.getString("descricao");
				double peso = rs.getDouble("peso");
				double altura = rs.getDouble("altura");
				double largura = rs.getDouble("largura");
				double profundidade = rs.getDouble("profundidade");
				double valor = rs.getDouble("valor");
				int remetenteId = rs.getInt("remetente_Id");
				int destinatarioId = rs.getInt("destinatario_Id");
				Objeto obj = new Objeto(numero, descricao, peso, altura, largura, profundidade, valor, remetenteId,
						destinatarioId);
				objeto.add(obj);
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
		return objeto;
	}

	@Override
	public ArrayList<Objeto> getList(String param) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<Objeto> objetos = new ArrayList<Objeto>();

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM objeto WHERE  numero = ?");
			stmt.setString(1, param);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				String numero = rs.getString("numero");
				String descricao = rs.getString("descricao");
				double peso = rs.getDouble("peso");
				double altura = rs.getDouble("altura");
				double largura = rs.getDouble("largura");
				double profundidade = rs.getDouble("profundidade");
				double valor = rs.getDouble("valor");
				int remetendeId = rs.getInt("remetendeId");
				int destinatarioId = rs.getInt("destinatarioId");
				
				
				Objeto objeto = new Objeto(numero, descricao, peso, altura, largura, profundidade,
						valor, remetendeId, destinatarioId);
				objetos.add(objeto);
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

		return objetos;
	}

	@Override
	public boolean alterar(Objeto elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeElement(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
