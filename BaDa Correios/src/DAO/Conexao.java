package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConexao() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/bd_correios", "root", "123456");
	}
}
