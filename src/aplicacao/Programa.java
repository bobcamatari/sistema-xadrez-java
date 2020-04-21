package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezExcessoes;

public class Programa {

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			UI.imprimirTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.println("Inicio: ");
			PosicaoXadrez inicial = UI.lendoPecaXadrez(sc);
			
			System.out.println();
			System.out.println("Final: ");
			PosicaoXadrez final1 = UI.lendoPecaXadrez(sc);
			
			PecaXadrez capturadaPeca = partidaXadrez.executarMudancaPeca(inicial, final1);
		}
	
	}

}
