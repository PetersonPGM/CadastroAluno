package View;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Aluno;
import Util.ListadeAlunos;

public class View {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException{

		System.out.println("Bem vindo ao sistema de cadastro"
				+ "\nDigite 1 para cadastro"
				+ "\nDigite 2 para consultas de alunos do sistema"
				+ "\nDigite 3 para deletar"
				+ "\nDigite 4 para editar"
				+ "\nDigite 5 para sair");
		System.out.println("");
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewMenuSalvarAluno (BufferedReader reader) throws NumberFormatException, IOException{
		String[] MensagemAluno = {"Nome: ","CPF: ","Curso: ","Rua: ","Número: ","Bairro: ","Cidade: ","Estado: ","CEP: "};
		
		String[] dadosAluno = {"", "", "", "", "", "", "", "", ""};
		
		for(int i = 0; i < MensagemAluno.length; i++) {
			System.out.println(MensagemAluno[i]);
			dadosAluno[i] = reader.readLine();
		}
		
		return dadosAluno;
	}
	
	public static int ViewDeletar(String editar_deletar, BufferedReader reader)  throws NumberFormatException, IOException {
		
		for(int i = 0; i < ListadeAlunos.getInstance().size(); i++)
			System.out.println(i + " - " + ListadeAlunos.getInstance().get(i));
		
		System.out.println();
		System.out.println("Dentre a lista acima, escolha o índice do aluno que deseja" + editar_deletar);
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewMenuEditarAluno (BufferedReader reader) throws NumberFormatException, IOException{
		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar:");
		System.out.println("1 - Nome\n"
				+ "2 - CPF\n"
				+ "3 - Curso\n"
				+ "4 - Rua\n"
				+ "5 - Número\n"
				+ "6 - Bairro\n"
				+ "7 - Cidade\n"
				+ "8 - Estado\n"
				+ "9 - CEP");
		dadosEditados[0] = reader.readLine();
				
		System.out.println("Escreva o novo valor do atributo");
		dadosEditados[1] = reader.readLine();
		
		return dadosEditados;
	}
	
	public static void ListaEditada(){
		
		for(Aluno a : ListadeAlunos.getInstance()) {
			System.out.println("-------------Aluno-------------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("CPF: " + a.getCpf());
			System.out.println("Curso: " + a.getCurso());
			System.out.println("Rua: " + a.getEndereco().getRua());
			System.out.println("Número: " + a.getEndereco().getNumero());
			System.out.println("Bairro: " + a.getEndereco().getBairro());
			System.out.println("Cidade: " + a.getEndereco().getCidade());
			System.out.println("Estado: " + a.getEndereco().getEstado());
			System.out.println("CEP: " + a.getEndereco().getCep());
		}
	}
	
	public static void ViewmsgFinal (int op) {
		String[] msg = {"Aluno salvo com sucesso", "Aluno editado com sucesso", "Aluno deletado com sucesso", "Fim"};
		
		System.out.println(msg[op]);
	}
}
