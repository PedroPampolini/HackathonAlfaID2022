package app;
import static spark.Spark.*;
import dao.FuncionarioDao;
import spark.*;
import service.serviceFuncionario;
import service.serviceEquipamento;


public class aplicacao {
	public static void main(String[] args) {
		FuncionarioDao fd = new FuncionarioDao();
		fd.conectar();
		port(3001);
		after((Filter) (request,response) -> {
			response.header("Access-Control-Allow-Origin","*");
			response.header("Access-Control-Allow-Methods", "GET");
			response.header("Access-Control-Allow-Methods", "POST");
		});
		
		get("/login/:cpf/:senha",(request,response) -> serviceFuncionario.login(request));
		get("/equipamentos",(request,response) -> serviceEquipamento.getAll());
	}
	
	
}
