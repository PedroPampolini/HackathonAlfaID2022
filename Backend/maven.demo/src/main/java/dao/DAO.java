package dao;

import java.sql.*;

public class DAO {
	protected Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "com.mysql.jdbc.Driver";
		String serverName = "localhost";
		String myDataBase = "omega";
		int porta = 2022;
		String url = "jdbc:mysql://" + serverName + ":" + porta + "/" + myDataBase;
		String username = "omega";
		String password = "gH#q2067J6g3";
		
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao efetuada com o servidor!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexao nao efetuada com o servidor -- Driver nao encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexao nao efetuada com o servidor -- " + e.getMessage());
		}

		return status;
		
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}
