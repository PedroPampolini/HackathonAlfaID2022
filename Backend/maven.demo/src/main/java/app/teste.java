package app;

import java.util.List;

import dao.DAO;
import dao.FuncionarioDao;
import model.Funcionario;


public class teste {
	public static void main(String[] args) {
		FuncionarioDao fd = new FuncionarioDao();
		/*List<Funcionario> lf = fd.getAll();
		
		for(int i = 0; i < lf.size(); i++) {
			System.out.println(i + " " + lf.get(i).toString());
		}*/
		
		System.out.println(fd.login("21354311110", "alfa@213")[0]);
	}
}
