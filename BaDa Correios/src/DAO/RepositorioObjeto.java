package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.entitys.Objeto;
import domain.interfaces.IRepositorio;

public class RepositorioObjeto implements IRepositorio<Objeto>{

	public void adicionar(Objeto objeto) {

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

	}

	@Override
	public Objeto get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Objeto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Objeto> getList(String param) {
		// TODO Auto-generated method stub
		return null;
	}
}
