package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListadeProdutos {
	/*Método responsável por criar uma lista de array para salvamento de informações e para a inicialização única do objeto
	 * */
	private static List<Produto> listprod = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listprod;
	}
}
