package model;

public class Funcionario {
	String cpf, senha, nome, email,permission_id,
	status, matricula, funcao_id;
	
	public Funcionario(){
		this("","","","","","","","");
	}

	public Funcionario(String cpf, String senha, String nome, String email, String permission_id, String status,
			String matricula, String funcao_id) {
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.permission_id = permission_id;
		this.status = status;
		this.matricula = matricula;
		this.funcao_id = funcao_id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFuncao_id() {
		return funcao_id;
	}

	public void setFuncao_id(String funcao_id) {
		this.funcao_id = funcao_id;
	}

	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", senha=" + senha + ", nome=" + nome + ", email=" + email
				+ ", permission_id=" + permission_id + ", status=" + status + ", matricula=" + matricula
				+ ", funcao_id=" + funcao_id + "]";
	}
	
	
}
