package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Marca;
import Modelos.Produto;
import Util.ListadeProdutos;

public class XMLHandler extends DefaultHandler{
	private StringBuilder texto;
	
	Produto prod;
	Marca marcaProd;
	
	@Override
	public void startDocument() throws SAXException {
		/*Método responsável por inicializar a preparação do arquivo XML para receber informações
		 * */
	}
	
	@Override
	public void endDocument() throws SAXException {
		/*Método responsável por Finalizar a preparação do arquivo XML
		 * */
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		/*Método responsável por inicializar o recebimento de informações capturadas no teclado, separação nas tags e gravação nos espaços especifícos
		 * */
		if(qName.equals("Produto")) {
			prod = new Produto();
			marcaProd = new Marca();
		} else {
			texto = new StringBuilder();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		/*Método responsável por Finalizar o recebimento de informações
		 * */
		if(qName.equals("Categoria")) {
			prod.setCategoria(texto.toString());
		} else if(qName.equals("Tipo")) {
			prod.setNome(texto.toString());
		} else if(qName.equals("Nomemarca")) {
			marcaProd.setNome(texto.toString());
		} else if(qName.equals("Preco")) {
			marcaProd.setPreco(Double.parseDouble(texto.toString()));
			prod.setMarca(marcaProd);
			
			ListadeProdutos.getInstance().add(prod);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		/*Método responsável por fazer a checagem de caracteres permitidos na construção do arquivo
		 * */
		texto.append(ch, start, length);
	}
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		/*Método responsável por captar qualquer erro no processo e enviar ao usuário
		 * */
	}
	
	
}
