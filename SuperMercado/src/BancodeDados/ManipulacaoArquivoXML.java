package BancodeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandler;
import Modelos.Produto;
import Util.ListadeProdutos;

public class ManipulacaoArquivoXML {
	private static String NomedoArquivo = "CadastrodeProdutos.xml";
	
	public static void SalvarXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		/*Método responsável por separar as informações capturadas no teclado e alocadas em variáveis para salvar em um arquivo XML
		 * */
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		Element prodtag = doc.createElement("Produtos");
		doc.appendChild(prodtag);
		
		for(Produto p : ListadeProdutos.getInstance()) {
			Element produtag = doc.createElement("Produto");
			produtag.setAttribute("id", "1");
			prodtag.appendChild(produtag);
			
			Element cattag = doc.createElement("Categoria");
			cattag.setTextContent(p.getCategoria());
			produtag.appendChild(cattag);
			
			Element tipotag = doc.createElement("Tipo");
			tipotag.setTextContent(p.getNome());
			produtag.appendChild(tipotag);
			
			Element marcatag = doc.createElement("Marca");
			produtag.appendChild(marcatag);
			
			Element nometag = doc.createElement("Nomemarca");
			nometag.setTextContent(p.getMarca().getNome());
			marcatag.appendChild(nometag);
			
			Element precotag = doc.createElement("Preco");
			precotag.setTextContent(String.valueOf(p.getMarca().getPreco()));
			marcatag.appendChild(precotag);
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		DOMSource source = new DOMSource(doc);
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(NomedoArquivo),"ISO-8859-1")){
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}
	}
	
	public static void LerXML () throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		/*Método responsável por pegar as informações salvas no arquivo XML e enviar a outro método para ser exibida no console
		 * */
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(NomedoArquivo),"ISO-8859-1")){
			InputSource source = new InputSource(isr);
			
			XMLHandler handler = new XMLHandler();
			
			parser.parse(source, handler);
		}
	}
}
