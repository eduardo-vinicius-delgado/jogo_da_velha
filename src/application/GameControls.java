package application;

import java.util.Scanner;
import entities.JogoDaVelha;

public class GameControls {
	
	private JogoDaVelha jogo = new JogoDaVelha();
	Scanner sc = new Scanner(System.in);
	private int[] controleJogadas = new int[9];
	char recomecar = ' ';
	private boolean jogoFinalizado;
	int jogada;
	public GameControls() {
		System.out.println("\nJogo da Velha! Para acessar as posições escolha os números de 1 a 9, sendo "
				+ "respectivamente as posições da esquerda para direita de cima para baixo");
		while(jogoFinalizado == false) {
			jogo.mostrarLayout();
			jogadaDoX();
			if(checarVelha()==true){
				continue;
			}
			if(checarGanhoX()==true) {
				continue;
			}
			
			jogo.mostrarLayout();
			jogadaDoO();
			if(checarVelha()==true){
				continue;
			}
			if(checarGanhoO()==true) {
				continue;
			}
			
		}
		jogo.mostrarLayout();
		System.out.println("Jogo terminado!");
		System.out.print("\nGostaria de recomeçar? S/N: ");
		sc.nextLine();
		recomecar = sc.nextLine().charAt(0);
		checarRecomeco(recomecar);
	}
	
	private void jogadaDoX() {
		System.out.print("\nVez do X: ");
		jogada = sc.nextInt();
		while(checarJogada(jogada) == 0){
			System.out.print("Posição inválida! Por favor escolha outra: ");
			jogada = sc.nextInt();
		}
		jogo.adicionarX(jogada);
	}
	
	private void jogadaDoO() {
		System.out.print("\nVez do O: ");
		jogada = sc.nextInt();
		while(checarJogada(jogada) == 0){
			System.out.print("Posição inválida! Por favor escolha outra: ");
			jogada = sc.nextInt();
		}
		jogo.adicionarO(jogada);
	}
	
	private int checarJogada(int jogada) {
		if(jogada < 0 || jogada >  9 ) {
			return 0;
		}else{
			for(int i = 0; i < controleJogadas.length ; i++) {
				if(controleJogadas[i] == jogada) {
					return 0;
				}
			}
		}
		controleJogadas[jogada-1] = jogada;
		return 1;
	}
	
	private boolean checarGanhoX() {
		int auxiliar = 0;
		for(int i = 0; i < jogo.getLayout().length ; i++) {
			if(jogo.getLayout()[i][auxiliar] == 'X' && jogo.getLayout()[i][auxiliar+1] == 'X' && jogo.getLayout()[i][auxiliar+2] == 'X') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][i] == 'X' && jogo.getLayout()[auxiliar+1][i] == 'X' && jogo.getLayout()[auxiliar+2][i] == 'X') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][auxiliar] == 'X' && jogo.getLayout()[auxiliar+1][auxiliar+1] == 'X' && jogo.getLayout()[auxiliar+2][auxiliar+2] == 'X') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][auxiliar+2] == 'X' && jogo.getLayout()[auxiliar+1][auxiliar+1] == 'X' && jogo.getLayout()[auxiliar+2][auxiliar] == 'X') {
				jogoFinalizado = true;
				return true;
			}
		}
		for(int i = 0; i < controleJogadas.length ;  i++) {
			if(controleJogadas[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checarGanhoO() {
		int auxiliar = 0;
		for(int i = 0; i < jogo.getLayout().length ; i++) {
			if(jogo.getLayout()[i][auxiliar] == 'O' && jogo.getLayout()[i][auxiliar+1] == 'O' && jogo.getLayout()[i][auxiliar+2] == 'O') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][i] == 'O' && jogo.getLayout()[auxiliar+1][i] == 'O' && jogo.getLayout()[auxiliar+2][i] == 'O') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][auxiliar] == 'O' && jogo.getLayout()[auxiliar+1][auxiliar+1] == 'O' && jogo.getLayout()[auxiliar+2][auxiliar+2] == 'O') {
				jogoFinalizado = true;
				return true;
			}else if(jogo.getLayout()[auxiliar][auxiliar+2] == 'O' && jogo.getLayout()[auxiliar+1][auxiliar+1] == 'O' && jogo.getLayout()[auxiliar+2][auxiliar] == 'O') {
				jogoFinalizado = true;
				return true;
			}
		}
		return false;
	}
	
	private boolean checarVelha() {
		for(int i = 0; i < controleJogadas.length ;  i++) {
			if(controleJogadas[i] == 0) {
				return false;
			}
		}
		jogoFinalizado = true;
		return true;
	}
	
	private GameControls checarRecomeco(char recomecar) {
		if(recomecar == 'S') {
			GameControls recomeco = new GameControls();
			return recomeco;
		}else {
			System.out.println("Saindo....");
			return null;
		}
	}

}
