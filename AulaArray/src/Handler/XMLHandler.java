package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListadeAlunos;

public class XMLHandler extends DefaultHandler {
	private StringBuilder texto;
	
	Aluno aluno;
	Endereco enderecoAluno;

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("Aluno")) {
			aluno = new Aluno();
			enderecoAluno = new Endereco();
		} else {
			texto = new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("Nome")) {
			aluno.setNome(texto.toString());
		} else if(qName.equals("CPF")) {
			aluno.setCpf(Integer.parseInt(texto.toString()));
		} else if(qName.equals("Curso")) {
			aluno.setCurso(texto.toString());
		} else if(qName.equals("Rua")) {
			enderecoAluno.setRua(texto.toString());
		} else if(qName.equals("Numero")) {
			enderecoAluno.setNumero(Integer.parseInt(texto.toString()));
		} else if(qName.equals("Bairro")) {
			enderecoAluno.setBairro(texto.toString());
		} else if(qName.equals("Cidade")) {
			enderecoAluno.setCidade(texto.toString());
		} else if(qName.equals("Estado")) {
			enderecoAluno.setEstado(texto.toString());
		} else if(qName.equals("CEP")) {
			enderecoAluno.setCep(Integer.parseInt(texto.toString()));
			aluno.setEndereco(enderecoAluno);
			
			ListadeAlunos.getInstance().add(aluno);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto.append(ch, start, length);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
	}
	
	
}