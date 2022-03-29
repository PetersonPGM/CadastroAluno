package BancodeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.Aluno;
import Util.ListadeAlunos;

public class ManipulacaoArquivoTXT{
	
	public static void SalvarTXT() throws IOException {
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeArquivo));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Aluno a : ListadeAlunos.getInstance())
				pw.println(a);
		}
	}

	public static void LerTXT() throws IOException {
		
		try(FileWriter arq = new FileWriter(nomeArquivo, true)){};
		
		String line;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
			while((line = reader.readLine()) != null && !"".equals(line)) {
					Aluno aluno = new Aluno(line);
					ListadeAlunos.getInstance().add(aluno);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String nomeArquivo = "CadastrodeAluno.txt";
}
