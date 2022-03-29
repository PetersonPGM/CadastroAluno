package Modelos;

public class Aluno {
	private String nome;
	private int cpf;
	private String curso;
	private Endereco endereco;
	
	public Aluno(String dados) {
	String[] atributos = dados.split(",");
	
	String[] nome = atributos[1].split("=");
	String[] cpf = atributos[2].split("=");
	String[] curso = atributos[3].split("=");
	
	Endereco  enderecos = new Endereco(atributos);
	
	this.nome = nome[1].trim();
	this.cpf = Integer.parseInt(cpf[1].trim());
	this.curso = curso[1].trim();
	this.endereco = enderecos;
	}
	
	public Aluno() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "AlunoX, Nome = " + nome + ", CPF = " + cpf + ", Curso = " + curso + ", Endereço = " + endereco;
	}
}
