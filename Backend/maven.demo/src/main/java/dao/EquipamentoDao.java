package dao;
import model.Equipamento;
import model.Funcionario;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EquipamentoDao extends DAO {

	public EquipamentoDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public List<Equipamento> getAll(){
		List<Equipamento> lista = new ArrayList<Equipamento>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT p.descricao, d.descricao FROM  produto p "
					+ "INNER JOIN derivacoes d ON d.produto_id = p.codigo;";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Equipamento equip = new Equipamento(rs.getString("descricao"),rs.getString("descricao"));		//Inserir parametros
				
				System.out.println(equip.toString());
				lista.add(equip);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return lista;
	}
}
