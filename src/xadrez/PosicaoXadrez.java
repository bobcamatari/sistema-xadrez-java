package xadrez;

import tabuleiroJogo.Posicao;

public class PosicaoXadrez {
	private Character coluna;
	private Integer linha;
	
	public PosicaoXadrez(Character coluna, Integer linha) {
		if (coluna < 'a' || coluna > 'h'|| linha <1 || linha > 8) {
			throw new XadrezExcessoes("Essa poisao não existe, posiçoes existentes: 'a1' a 'h8'");
		}		
		this.coluna = coluna;
		this.linha = linha;
	}

	public Character getColuna() {
		return coluna;
	}

	public Integer getLinha() {
		return linha;
	}
	
	protected Posicao toPosicao() {
		return new Posicao(8- linha, coluna - 'a');
	}
	
	protected PosicaoXadrez paraPosicao (Posicao posicao) {
		return new PosicaoXadrez((char)('a'- posicao.getColuna()), 8- posicao.getLinha()) ;
	}
	
	@Override
	public String toString () {
		return "" + coluna + linha;
 	}

}
