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
import Modelos.Aluno;
import Util.ListadeAlunos;

public class ManipulacaoArquivoXML {
	
	private static String NomedoArquivo = "CadastrodeAluno.xml";

	public static void SalvarXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		Element alunostag = doc.createElement("Alunos");
		doc.appendChild(alunostag);
		
		for(Aluno a : ListadeAlunos.getInstance()) {
			Element alunotag = doc.createElement("Aluno");
			alunotag.setAttribute("id", "1");
			alunostag.appendChild(alunotag);
			
			Element nometag = doc.createElement("Nome");
			nometag.setTextContent(a.getNome());
			alunotag.appendChild(nometag);
			
			Element cpftag = doc.createElement("CPF");
			cpftag.setTextContent(String.valueOf(a.getCpf()));
			alunotag.appendChild(cpftag);
			
			Element cursotag = doc.createElement("Curso");
			cursotag.setTextContent(a.getCurso());
			alunotag.appendChild(cursotag);
			
			Element enderecotag = doc.createElement("Endereco");
			alunotag.appendChild(enderecotag);
			
			Element ruatag = doc.createElement("Rua");
			ruatag.setTextContent(a.getEndereco().getRua());
			enderecotag.appendChild(ruatag);
			
			Element numerotag = doc.createElement("Numero");
			numerotag.setTextContent(String.valueOf(a.getEndereco().getNumero()));
			enderecotag.appendChild(numerotag);
			
			Element bairrotag = doc.createElement("Bairro");
			bairrotag.setTextContent(a.getEndereco().getBairro());
			enderecotag.appendChild(bairrotag);
			
			Element cidadetag = doc.createElement("Cidade");
			cidadetag.setTextContent(a.getEndereco().getCidade());
			enderecotag.appendChild(cidadetag);
			
			Element estadotag = doc.createElement("Estado");
			estadotag.setTextContent(a.getEndereco().getEstado());
			enderecotag.appendChild(estadotag);
			
			Element ceptag = doc.createElement("CEP");
			ceptag.setTextContent(String.valueOf(a.getEndereco().getCep()));
			enderecotag.appendChild(ceptag);
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
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(NomedoArquivo),"ISO-8859-1")){
			InputSource source = new InputSource(isr);
			
			XMLHandler handler = new XMLHandler();
			
			parser.parse(source, handler);
		}
	}
}
