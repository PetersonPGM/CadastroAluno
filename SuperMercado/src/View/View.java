package View;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Produto;
import Util.ListadeProdutos;

public class View {
	/*Método responsável por exibir todas as informações visuais da classe principal
	 * */
	public static int ViewMenuMain(BufferedReader reader) throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("Bem vindo ao sistema de cadastro Point Market"
				+ "\nDigite 1 para cadastro"
				+ "\nDigite 2 para consultas de produtos do sistema"
				+ "\nDigite 3 para exclusão de produtos no sistema"
				+ "\nDigite 4 para edição de produtos no sistema"
				+ "\nDigite 5 para sair");
		System.out.println("");
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewSalvar (BufferedReader reader) throws IOException {
		/*Método responsável por exibir todas as informações visuais relacionadas ao método de gravação
		 * */
		String[] mensagem = {"Categoria do produto: ", "Tipo do produto: ", "Nome da marca: ", "Preço: "};
		
		String[] dados = {"", "", "", ""};
		
		for(int i = 0; i < mensagem.length; i++) {
			System.out.println(mensagem[i]);
			dados[i] = reader.readLine();
		}
		return dados;
	}
	
	public static int ViewDeletar(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		/*Método responsável por exibir todas as informações visuais dao método de exclusão
		 * */
		for(int i = 0; i < ListadeProdutos.getInstance().size(); i++)
			System.out.println(i + " - " + ListadeProdutos.getInstance().get(i));
		
		System.out.println();
		
		System.out.println("Dentre a lista acima, escolha o índice do produto que deseja" + editar_deletar);
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewEditar (BufferedReader reader) throws IOException {
		/*Método responsável por exibir todas as informações visuais ao método de edição
		 * */
		String[] edicao = {"","","",""};
		
		System.out.println("O que deseja alterar");
		System.out.println("[1] - Categoria do produto\n"
				+ "[2] - Tipo do produto\n"
				+ "[3] - Nome da marca\n"
				+ "[4] - Preço");
		
		edicao[0] = reader.readLine();
		
		System.out.println("Digite a nova informação");
		edicao[1] = reader.readLine();
		
		return edicao;
	}
	
	public static void ListaEditada () {
		/*Método responsável por exibir a lista que foi salva, no console
		 * */
		for (Produto p : ListadeProdutos.getInstance()) {
			System.out.println("------------------Produto-------------------");
			System.out.println("Categoria: " + p.getCategoria());
			System.out.println("Tipo: " + p.getNome());
			System.out.println("Marca: " + p.getMarca().getNome());
			System.out.println("Preço: " + p.getMarca().getPreco());
		}
	}
	
	public static void ViewFinal (int op) {
		/*Método responsável por exibir todas as informações visuais relacionadas ao fim de cada caso no menu
		 * */
		String[] msg = {"Produto cadastrado com sucesso", "Edição realizada com sucesso", "Exclusão realizada com sucesso", "Obrigado por usar nosso sistema Tenha um bom dia! Powered by SENAI SP"};
		
		System.out.println(msg[op]);
	}
}
