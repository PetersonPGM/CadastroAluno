package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;

public class ListadeAlunos {
	private static List<Aluno> listaAluno = new ArrayList<Aluno>();
	
	public static List<Aluno> getInstance(){
		return listaAluno;
	}
}
