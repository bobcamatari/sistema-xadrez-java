package xadrez;

import tabuleiroJogo.ExcessoesTabuleiro;
import tabuleiroJogo.Peca;
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

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.pecas(i, j);
			}
		}
		return mat;
	}
	
	public PecaXadrez executarMudancaPeca (PosicaoXadrez inicialPosicao, PosicaoXadrez finalPosicao) {
		Posicao inicial = inicialPosicao.toPosicao();
		Posicao final1 = finalPosicao.toPosicao();
		validaInicalPosicao(inicial);
		Peca capturadaPeca = makeMove(inicial, final1);
		return (PecaXadrez) capturadaPeca;
		
	}

	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private Peca makeMove (Posicao inicail, Posicao final1) { 
		Peca p = tabuleiro.removerPeca(inicail);
		Peca capturadaPeca = tabuleiro.removerPeca(final1);
		tabuleiro.colocarPeca(p, final1);
		return capturadaPeca;
	}
	
	private void validaInicalPosicao (Posicao posicao) {
		if(!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezExcessoes("Nao existe peça nessa posiçao");
		}
	}	
	
	private void inicialConfiguracao() {
			colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRACO));
		colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRACO));
		colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRACO));
		colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRACO));
		colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRACO));
		colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRACO));
		
		colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

}