package Aplicacao;
import java.io.BufferedReader; //Área de importação de classes e bibliotecas que acarretarão no bom funcionamento do algoritmo.
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.View;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, SAXException, TransformerException {
		//Método responsável por inicializar os outros métodos em outras classes
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CRUDProd.listagem(1); //Linha para carregamento da lista, evitando assim a sobrescrição das informações.
		
		int menu = 0;
		
		while(menu != 5) {
			
			menu = View.ViewMenuMain(reader);
			
		switch(menu) {
			case 1:
				CRUDProd.SalvarProduto(reader);
				View.ViewFinal(0);
				break;
				
			case 2:
				CRUDProd.listagem(0);
				break;
				
			case 3:
				CRUDProd.Deletar(reader);
				View.ViewFinal(2);
				break;
				
			case 4:
				CRUDProd.editar(reader);
				View.ViewFinal(1);
				break;
				
			case 5:
				View.ViewFinal(3);
			}
		}
	}
}
