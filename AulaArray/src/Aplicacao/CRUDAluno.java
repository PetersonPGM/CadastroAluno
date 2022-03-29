package Aplicacao;
import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancodeDados.ManipulacaoArquivoTXT;
import BancodeDados.ManipulacaoArquivoXML;
import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListadeAlunos;
import View.View;

public class CRUDAluno {

	public static Aluno SalvarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
		
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		
		String[] dadosAluno = View.ViewMenuSalvarAluno(reader);

				aluno.setNome(dadosAluno[0]);
				aluno.setCpf(Integer.parseInt(dadosAluno[1 ]));
				aluno.setCurso(dadosAluno[2]);
				endereco.setRua(dadosAluno[3]);
				endereco.setNumero(Integer.parseInt(dadosAluno[4]));
				endereco.setBairro(dadosAluno[5]);
				endereco.setCidade(dadosAluno[6]);
				endereco.setEstado(dadosAluno[7]);
				endereco.setCep(Integer.parseInt(dadosAluno[8]));
			aluno.setEndereco(endereco);
			
			ListadeAlunos.getInstance().add(aluno);
			
			ManipulacaoArquivoTXT.SalvarTXT();
			ManipulacaoArquivoXML.SalvarXML();
	
		return aluno;
	}
	
	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException{
		
		int indice = View.ViewDeletar(" deletar", reader);
		
		ListadeAlunos.getInstance().remove(indice);
		
		ManipulacaoArquivoTXT.SalvarTXT();
		ManipulacaoArquivoXML.SalvarXML();
	}
	
	public static void listagem(int op) throws IOException, ParserConfigurationException, SAXException {
		
		ListadeAlunos.getInstance().clear();
		
		//ManipulacaoArquivoTXT.LerTXT();
		ManipulacaoArquivoXML.LerXML();
		
		if(op == 0) {
			View.ListaEditada();
		}
	}
	
	public static void editar (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
		String[] dadosEditados = {"",""};
		
		int indice = View.ViewDeletar(" editar", reader);
		
		Aluno aluno = ListadeAlunos.getInstance().get(indice);
		aluno.getEndereco();
		
		dadosEditados = View.ViewMenuEditarAluno(reader);
		
		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			aluno.setNome(dadosEditados[1]);
			break;
		case 2:
			aluno.setCpf(Integer.parseInt(dadosEditados[1]));
			break;
		case 3:
			aluno.setCurso(dadosEditados[1]);
			break;
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			break;
		case 5:
			aluno.getEndereco().setNumero(Integer.parseInt(dadosEditados[1]));
			break;
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			break;
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			break;
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			break;
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			break;
		}
		
		ListadeAlunos.getInstance().set(indice, aluno);
		
		ManipulacaoArquivoTXT.SalvarTXT();
		ManipulacaoArquivoXML.SalvarXML();
	}
}