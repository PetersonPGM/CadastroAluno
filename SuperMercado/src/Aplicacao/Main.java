package Aplicacao;
import java.io.BufferedReader; //�rea de importa��o de classes e bibliotecas que acarretar�o no bom funcionamento do algoritmo.
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.View;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, SAXException, TransformerException {
		//M�todo respons�vel por inicializar os outros m�todos em outras classes
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CRUDProd.listagem(1); //Linha para carregamento da lista, evitando assim a sobrescri��o das informa��es.
		
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
