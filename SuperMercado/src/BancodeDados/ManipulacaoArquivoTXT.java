package BancodeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.Produto;
import Util.ListadeProdutos;

public class ManipulacaoArquivoTXT {
	
	public static void SalvarTXT() throws IOException {
		/*M�todo respons�vel por separar as informa��es capturadas no teclado e alocadas em vari�veis para salvar em um arquivo TXT
		 * */
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeArquivo));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Produto p : ListadeProdutos.getInstance())
				pw.println(p);
		}
	}
	
	public static void LerTXT() throws IOException {
		/*M�todo respons�vel por pegar as informa��es salvas no arquivo TXT e enviar a outro m�todo para ser exibida no console
		 * */
		try(FileWriter arq = new FileWriter(nomeArquivo, true)){};
		
		String line;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
			while((line = reader.readLine()) != null && !"".equals(line)) {
				Produto produto = new Produto(line);
				ListadeProdutos.getInstance().add(produto);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String nomeArquivo = "CadastrodeProdutos.txt";
}
