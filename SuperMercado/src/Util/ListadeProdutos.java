package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListadeProdutos {
	/*M�todo respons�vel por criar uma lista de array para salvamento de informa��es e para a inicializa��o �nica do objeto
	 * */
	private static List<Produto> listprod = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listprod;
	}
}
