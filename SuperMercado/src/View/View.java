package View;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Produto;
import Util.ListadeProdutos;

public class View {
	/*M�todo respons�vel por exibir todas as informa��es visuais da classe principal
	 * */
	public static int ViewMenuMain(BufferedReader reader) throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("Bem vindo ao sistema de cadastro Point Market"
				+ "\nDigite 1 para cadastro"
				+ "\nDigite 2 para consultas de produtos do sistema"
				+ "\nDigite 3 para exclus�o de produtos no sistema"
				+ "\nDigite 4 para edi��o de produtos no sistema"
				+ "\nDigite 5 para sair");
		System.out.println("");
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewSalvar (BufferedReader reader) throws IOException {
		/*M�todo respons�vel por exibir todas as informa��es visuais relacionadas ao m�todo de grava��o
		 * */
		String[] mensagem = {"Categoria do produto: ", "Tipo do produto: ", "Nome da marca: ", "Pre�o: "};
		
		String[] dados = {"", "", "", ""};
		
		for(int i = 0; i < mensagem.length; i++) {
			System.out.println(mensagem[i]);
			dados[i] = reader.readLine();
		}
		return dados;
	}
	
	public static int ViewDeletar(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		/*M�todo respons�vel por exibir todas as informa��es visuais dao m�todo de exclus�o
		 * */
		for(int i = 0; i < ListadeProdutos.getInstance().size(); i++)
			System.out.println(i + " - " + ListadeProdutos.getInstance().get(i));
		
		System.out.println();
		
		System.out.println("Dentre a lista acima, escolha o �ndice do produto que deseja" + editar_deletar);
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewEditar (BufferedReader reader) throws IOException {
		/*M�todo respons�vel por exibir todas as informa��es visuais ao m�todo de edi��o
		 * */
		String[] edicao = {"","","",""};
		
		System.out.println("O que deseja alterar");
		System.out.println("[1] - Categoria do produto\n"
				+ "[2] - Tipo do produto\n"
				+ "[3] - Nome da marca\n"
				+ "[4] - Pre�o");
		
		edicao[0] = reader.readLine();
		
		System.out.println("Digite a nova informa��o");
		edicao[1] = reader.readLine();
		
		return edicao;
	}
	
	public static void ListaEditada () {
		/*M�todo respons�vel por exibir a lista que foi salva, no console
		 * */
		for (Produto p : ListadeProdutos.getInstance()) {
			System.out.println("------------------Produto-------------------");
			System.out.println("Categoria: " + p.getCategoria());
			System.out.println("Tipo: " + p.getNome());
			System.out.println("Marca: " + p.getMarca().getNome());
			System.out.println("Pre�o: " + p.getMarca().getPreco());
		}
	}
	
	public static void ViewFinal (int op) {
		/*M�todo respons�vel por exibir todas as informa��es visuais relacionadas ao fim de cada caso no menu
		 * */
		String[] msg = {"Produto cadastrado com sucesso", "Edi��o realizada com sucesso", "Exclus�o realizada com sucesso", "Obrigado por usar nosso sistema Tenha um bom dia! Powered by SENAI SP"};
		
		System.out.println(msg[op]);
	}
}
