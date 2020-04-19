package xadrez;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicialConfiguracao();
	}
	
	public PecaXadrez [][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i< tabuleiro.getLinhas(); i++) {
			for(int j=0; j< tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.pecas(i, j);
			}
		} 		
		return mat;
	}
	
	private void inicialConfiguracao() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRACO), new Posicao(7, 4));
	}

}
