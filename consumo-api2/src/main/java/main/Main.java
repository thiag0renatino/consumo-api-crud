package main;

import java.io.IOException;
import java.util.Scanner;


import controller.FilmeController;
import model.dao.FilmeDAO;
import model.dao.oracleConnection.OracleConnection;
import model.vo.Filme;
import service.Api_OMDB;
import view.ViewConsole;

public class Main {

	public static void main(String[] args) {
		
		Api_OMDB apiFilme = new Api_OMDB();
		
		Scanner sc = new Scanner(System.in);
		
		FilmeController filmeController = new FilmeController(new FilmeDAO(OracleConnection.getInstance()) , ViewConsole.getInstance());
		
		int menu = 0;
				
		while (menu != 5) {
			
			System.out.println("========||Menu||========"+
								"\n1 - Consultar Filme/ Cadastrar Filme" +
								"\n2 - Excluir Filme Cadastrado" +
								"\n3 - Atualizar MetaScore do Filme Cadastrado" +
								"\n4 - Exibir Filme Cadastrado"+
								"\n5 - Sair");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				
			case 1: {
				System.out.println("========||Consultar Filme||========");
				System.out.println("\nInserir Título do Filme: (EX: Matrix)");
				String Title = sc.nextLine();
				try {
					Filme filme = apiFilme.getFilme(Title);
					
					System.out.println(filme.toString());
					System.out.println();
					System.out.println("=======================================");
					System.out.println("\nCadastrar Filme Inserido ? [s] ou [n]");
					char r = sc.next().charAt(0);
					if (r == 's') {
						filmeController.cadastrarFilme(filme);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException i) {
					i.printStackTrace();
				}
				System.out.println();
				break;	
			}
			case 2: {
				System.out.println("========||Excluir Filme Cadastrado||========");
				System.out.println("\nInserir Título do Filme: (EX: Matrix)");
				String Title = sc.next();
				filmeController.deletarFilme(Title);
				System.out.println();
				break;

			}
			case 3: {
				System.out.println("========||Atualizar MetaScore||========");
				System.out.println("\nNovo MetaScore: ");
				String Metascore = sc.next();
				System.out.println("\nFilme para ser Atualizado: (EX: Matrix)");
				String Title = sc.next();
				filmeController.atualizarFilme(Metascore, Title);
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("========||Exibir Filme Cadastrado||========");
				System.out.println("\nFilme a ser Exibido: (EX: Matrix)");
				String Title = sc.next();
				
				filmeController.buscarFilme(Title);
				System.out.println();
				break;
				}
			case 5: {
				System.out.println("========|| Saindo... ||========");
				break;
			}
			default: {
				System.out.println("OPÇÃO INVÁLIDA!");
				System.out.println();
			}
				
		}
				
				
				
		
				
					
					
			}
		sc.close();
		
				
		}
			
	
	}
		
		
	
		

	


