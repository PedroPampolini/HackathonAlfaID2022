package service;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import spark.*;

import model.Funcionario;
import dao.FuncionarioDao;

public class serviceFuncionario {
	public static String login(Request request) {
		String cpf = request.params(":cpf");
		String senha = request.params(":senha");
		String result[] = new String[2];
		try {
			FuncionarioDao fd = new FuncionarioDao();
			fd.conectar();
			result = fd.login(cpf, senha);
			
		}
		catch(Exception e) {
			result[0] = "NEGADO";
			result[1] = cpf;
			System.err.println(e.getMessage());
		}
		return "{\"" + result[0] + "\", \"" + result[1] + "\"}";
	}
}
