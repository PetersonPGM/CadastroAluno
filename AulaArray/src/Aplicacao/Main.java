package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.View;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CRUDAluno.listagem(1);
		
		int menu = 0;
		
		while(menu != 5) {
			
			menu = View.ViewMenuPrincipal(reader);
			
		switch(menu) {
			case 1:
				CRUDAluno.SalvarAluno(reader);
				break;
				
			case 2:
				CRUDAluno.listagem(0);
				break;
				
			case 3:
				CRUDAluno.DeletarAluno(reader);
				break;
				
			case 4:
				CRUDAluno.editar(reader);
				break;
				
			case 5:
				System.out.println("");
				System.out.println("Obrigado por usar nosso sistema"
						+ "\nTenha um bom dia!"
						+ "\nPowered by SENAI SP");
				
				View.ViewmsgFinal(3);
			}
		}
	}
}
