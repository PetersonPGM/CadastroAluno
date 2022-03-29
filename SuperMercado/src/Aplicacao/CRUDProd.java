package Aplicacao;
import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancodeDados.ManipulacaoArquivoTXT;
import BancodeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListadeProdutos;
import View.View;

public class CRUDProd {
	public static Produto SalvarProduto (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {
		/*M�todo respons�vel por capturar o que � digitado, atribuir a cada vari�vel especifica bem como enviar para o salvamento nos arquivos TXT e XML
		 */
		
		/*Instancia��o das classes produto e marca
		 */
		Produto produto = new Produto();
		Marca marca = new Marca();

		String[] dadosProd = View.ViewSalvar(reader);
		
				produto.setCategoria(dadosProd[0]);
				produto.setNome(dadosProd[1]);
				marca.setNome(dadosProd[2]);
				marca.setPreco(Double.parseDouble(dadosProd[3]));
				produto.setMarca(marca);
				
				/*pega as inst�ncias das vari�veis e adiciona informa��es inseridas pelo teclado a todas as vari�veis instanciadas
				 */
				ListadeProdutos.getInstance().add(produto);
				
				/*Salva as infroma��es em arquivos TXT e XML
				 */
				ManipulacaoArquivoTXT.SalvarTXT();
				ManipulacaoArquivoXML.SalvarXML();
		return produto;
	}
	
	
	public static void listagem(int op) throws IOException, ParserConfigurationException, SAXException {
		
		/*M�todo respons�vel por buscar as informa��es na mem�ria tempor�ria e nos arquivos TXT e XML para assim as exibir no console
		 * */
		
		ListadeProdutos.getInstance().clear();
		
		/*Busca as informa��es contidas nos arquivos e lista para o usu�rio
		 */
		ManipulacaoArquivoTXT.LerTXT();
		ManipulacaoArquivoXML.LerXML();
		
		
		if(op == 0) {
			View.ListaEditada();
		}
	}
	
	public static void Deletar(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		/*M�todo respons�vel por buscar as informa��es no arquivo TXT e XML, deleta a informa��o que foi especificamente selecionada e salva o espa�o onde ela estava como vazio, deixando-a livre para ser utilizada novamente
		 * Semelhante a um HD 
		 * */
		
		int indice = View.ViewDeletar(" deletar", reader);
		
		ListadeProdutos.getInstance().remove(indice);
		
		/*Salva as infroma��es em arquivos TXT e XML
		 */
		ManipulacaoArquivoTXT.SalvarTXT();
		ManipulacaoArquivoXML.SalvarXML();
	}
	
	public static void editar (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		/*M�todo respons�vel por buscar as informa��es nos arquivos, selecionar a especifica, dar um novo valor a ela e salvar novamente nos arquivos*/
		String[] dadosEditados = {"","","",""};
		
		int indice = View.ViewDeletar(" editar", reader);
		
		Produto produto = ListadeProdutos.getInstance().get(indice);
		produto.getMarca();
		
		dadosEditados = View.ViewEditar(reader);
		
		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			produto.setCategoria(dadosEditados[1]);
			break;
		case 2:
			produto.setNome(dadosEditados[1]);
			break;
		case 3:
			produto.getMarca().setNome(dadosEditados[1]);
			break;
		case 4:
			produto.getMarca().setPreco(Double.parseDouble(dadosEditados[1]));
			break;
		}
		
		ListadeProdutos.getInstance().set(indice, produto);
		
		/*Salva as infroma��es em arquivos TXT e XML
		 */
		ManipulacaoArquivoTXT.SalvarTXT();
		ManipulacaoArquivoXML.SalvarXML();
	}
}
