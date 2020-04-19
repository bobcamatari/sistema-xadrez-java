package tabuleiroJogo;

public class Tabuleiro {
	private Integer linhas;
	private Integer colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(Integer linhas, Integer colunas) {
		if (linhas <1 || colunas < 1) {
			throw new ExcessoesTabuleiro("Erro ao criar tabuleiro: É nescesario pelo menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca [linhas][colunas];
	}

	public Integer getLinhas() {
		return linhas;
	}	

	public Integer getColunas() {
		return colunas;
	}
	
	public Peca pecas (int linha, int coluna) {
		if (!posicaoExistente(coluna, linha)) {
			throw new ExcessoesTabuleiro("Essa posiçao nao existe no tabuleiro");
		}
		return pecas [linha][coluna];
	}
	
	public Peca pecas (Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new ExcessoesTabuleiro("Essa posicao nao existe no tabuleiro");
		}
		return pecas [posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new ExcessoesTabuleiro("Ja existe uma peca na posicao" + posicao);
		}
		pecas [posicao.getLinha()][posicao.getColuna()]= peca;
		peca.posicao = posicao;		
	}
	
	private boolean posicaoExistente(int linha, int coluna) {
		return	linha >=0 && linha < linhas && coluna >=0 && coluna < colunas; 
	}
	
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
		
	}
	
	public boolean temUmaPeca (Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new ExcessoesTabuleiro("Essa posicao nao existe no tabuleiro");
		}
		return pecas(posicao) != null;
	}

}
