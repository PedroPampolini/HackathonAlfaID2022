package service;
import java.util.List;
import dao.EquipamentoDao;
import dao.FuncionarioDao;
import model.Equipamento;


public class serviceEquipamento {
	public static String getAll() {
		String result = new String();
		try {
			EquipamentoDao ed = new EquipamentoDao();
			ed.conectar();
			List<Equipamento> equip = ed.getAll();
			for(int i = 0; i < equip.size(); i++) {
				result += (i+1) + ") " + equip.get(i) + " asdn ";
			}
			
		}
		catch(Exception e) {
			result = "";
		}
		return result;
		
	}
}
