package dao;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioDao extends DAO {
	
	public FuncionarioDao(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public List<Funcionario> getAll(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM funcionario";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getString("cpf"),rs.getString("senha"),rs.getString("nome"),
						rs.getString("email"),rs.getString("permission_id"),rs.getString("status"),rs.getString("matricula"),
						rs.getString("funcao_id"));		//Inserir parametros
				lista.add(f);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return lista;
	}
	
	public String[] login(String cpf, String senha) {
		Funcionario f = new Funcionario();
		String[] result = new String[2];
		result[0] = "NEGADO";
		result[1] = cpf;
		try {
			String query = "SELECT * FROM funcionario WHERE cpf= ? AND senha= ?;";
			PreparedStatement st = conexao.prepareStatement(query);
			st.setString(1,cpf);
			st.setString(2, senha);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				query = "SELECT cpf, descricao from funcoes "
						+ "INNER JOIN funcionario ON funcao_id = codigo AND cpf = '" + cpf + "';";
				Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs2 = st2.executeQuery(query);
				if(rs2.next()) {
					String cargo = rs2.getString("descricao");
					if(cargo.indexOf("ENCARREGADO") != -1) {
						result[0] = "ENCARREGADO";
					}
					else if(cargo.indexOf("GERENTE") != -1) {
						result[0] = "GERENTE";
					}
				}
			}
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
}
