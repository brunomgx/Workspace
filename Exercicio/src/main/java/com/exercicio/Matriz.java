package com.exercicio;

import java.util.logging.Logger;

/**
 * @author Bruno C. S. Feliciano
 *
 */
public class Matriz {

	/**
	 * Controle de Log.
	 */
	private static final Logger log = Logger.getLogger(Matriz.class.getName());
	
	// ATRIBUTOS DE CONTROLE
	private final int X_INICIAL = 0; // Número inicial do eixo horizontal.
	private final int Y_INICIAL = 0; // Número inicial do eixo vertical.
	private int X_FINAL = 0; // Número final do eixo horizontal (Inicializado no construtor).
	private int Y_FINAL = 0; // Número final do eixo horizontal (Inicializado no construtor).
	private final String CELULA_VAZIA = "-"; // Valor retornado para células vazias.
	
	// ATRIBUTOS DA MATRIZ
	private String[][] posicao; //vetor multidimensional para armazenar valores.
	private int qtLinhas; // atributo com quantidade de linhas da matriz.
	private int qtColunas; //atributo ocm quantidade de colunas da matriz.

	/**
	 * Contrutor.
	 * @param qtColunas
	 * @param qtLinhas
	 */
	public Matriz(int qtColunas, int qtLinhas) {
		this.posicao = new String[qtColunas][qtLinhas];
		this.qtColunas = qtColunas;
		this.qtLinhas = qtLinhas;
		X_FINAL = this.qtColunas - 1;
		Y_FINAL = this.qtLinhas - 1;
	}
	
	/**
	 * Método printMatriz.
	 */
	public void printMatriz() {
		for(int y = 0; y <= Y_FINAL; y++) {
			for(int x = 0; x <= X_FINAL; x++) {
				System.out.print(getPosicao(x, y));
			}
			System.out.println();
		}
	}
	
	/**
	 * Método getPosicao.
	 * @param x
	 * @param y
	 * @return String
	 */
	public String getPosicao(int x, int y) {
		if (this.posicao != null 
				&& isPosicaoValida(x, y)) {
			if (this.posicao[x][y] != null) {
				return this.posicao[x][y];
			} else {
				return CELULA_VAZIA;
			}
		} else {
			log.warning("Acesso a posição inválida da matriz.");
			return CELULA_VAZIA;	
		}
	}
	
	/**
	 * Método setPosicao.
	 * @param x
	 * @param y
	 * @param valor
	 */
	public void setPosicao(int x, int y, String valor) {
		if (this.posicao != null 
				&& isPosicaoValida(x, y)) {
			this.posicao[x][y] = valor;
		} else {
			log.warning("Acesso a posição inválida da matriz.");
		}
	}
	
	/**
	 * Método getPosicaoInicial.
	 * @return String
	 */
	public String getPosicaoInicial() {
		return getPosicao(X_INICIAL, Y_INICIAL);
	}
	
	/**
	 * Método isPosicaoVazia.
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public boolean isPosicaoVazia(int x, int y) {
		return CELULA_VAZIA.equals(getPosicao(x, y));
	}
	
	/**
	 * Método isPosicaoValida.
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public boolean isPosicaoValida(int x, int y) {
		return x >= X_INICIAL && x <= X_FINAL && y >= Y_INICIAL && y <= Y_FINAL;
	}

	/**
	 * Método getQtLinhas.
	 * @return int
	 */
	public int getQtLinhas() {
		return qtLinhas;
	}

	/**
	 * Método getQtColunas.
	 * @return int
	 */
	public int getQtColunas() {
		return qtColunas;
	}
	
}
