package com.exercicio;

import java.io.FileReader;
import java.util.logging.Logger;

/**
 * @author Bruno C. S. Feliciano
 *
 */
public class PesquisaMatriz {

	/**
	 * Controle de Log.
	 */
	private static final Logger log = Logger.getLogger(PesquisaMatriz.class.getName());
	
	// ATRIBUTOS DE CONTROLE
	private final String INDEX_MATCH = "M"; // Indica que a pesquisa foi localizada dentro da matriz.
	private final String INDEX_POTENCIAL = "P"; // Indica um poss�vel �ndice em que a pesquisa pode ser realizada.
	private final String INDEX_FAIL = "F"; // Indica que a pesquisa n�o foi localizada dentro da matriz.
	
	// ATRIBUTOS DA PESQUISA
	private Matriz matrizOriginal; // Matriz orginal na qual ser� realizada a pesquisa.
	private Matriz matrizPesquisa; // Matriz a ser pesquisada.
	private Matriz matrizIndice; // Matriz auxiliar de �ndices para indicar valroes encontrados.
	private Matriz matrizResultado; // Matriz contendo o resultado final da pesquisa.
	
	/**
	 * M�todo pesquisarMatriz.
	 * @param diretorio
	 * @param nomeArquivo
	 */
	public boolean pesquisarMatriz(String diretorio, String nomeArquivo) {
		try {
			ArquivoMatriz arquivoMatriz = new ArquivoMatriz();
			arquivoMatriz.leituraArquivo(diretorio, nomeArquivo);
			setMatrizOriginal(arquivoMatriz.gerarMatrizOriginal());
			setMatrizPesquisa(arquivoMatriz.gerarMatrizPesquisa());
			iniciarPesquisa();
			mostrarResultado();
			return true;
		} catch (Exception e) {
			log.severe("N�o foi possivel realizar a pesquisa na Matriz.");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * M�todo pesquisarMatriz.
	 * @param diretorio
	 * @param nomeArquivo
	 */
	public boolean pesquisarMatriz(String nomeArquivo) {
		try {
			ArquivoMatriz arquivoMatriz = new ArquivoMatriz();
			arquivoMatriz.leituraArquivo(nomeArquivo);
			setMatrizOriginal(arquivoMatriz.gerarMatrizOriginal());
			setMatrizPesquisa(arquivoMatriz.gerarMatrizPesquisa());
			iniciarPesquisa();
			mostrarResultado();
			return true;
		} catch (Exception e) {
			log.severe("N�o foi possivel realizar a pesquisa na Matriz.");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * M�todo pesquisarMatriz.
	 * @param diretorio
	 * @param nomeArquivo
	 */
	public boolean pesquisarMatriz(FileReader arquivo) {
		try {
			ArquivoMatriz arquivoMatriz = new ArquivoMatriz();
			arquivoMatriz.leituraArquivo(arquivo);
			setMatrizOriginal(arquivoMatriz.gerarMatrizOriginal());
			setMatrizPesquisa(arquivoMatriz.gerarMatrizPesquisa());
			iniciarPesquisa();
			mostrarResultado();
			return true;
		} catch (Exception e) {
			log.severe("N�o foi possivel realizar a pesquisa na Matriz.");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * M�todo iniciarPesquisa.
	 */
	private void iniciarPesquisa() {
		setMatrizIndice(new Matriz(getMatrizOriginal().getQtColunas(), getMatrizOriginal().getQtLinhas()));
		setMatrizResultado(new Matriz(getMatrizOriginal().getQtColunas(), getMatrizOriginal().getQtLinhas()));
		caminharMatrizOriginal();
	}
	
	/**
	 * M�todo caminharMatrizOriginal.
	 */
	private void caminharMatrizOriginal() {
		for(int y = 0; y < getMatrizOriginal().getQtLinhas(); y++) {
			for(int x = 0; x < getMatrizOriginal().getQtColunas(); x++) {
				if(INDEX_POTENCIAL.equals(getMatrizIndice().getPosicao(x, y))
						|| getMatrizIndice().isPosicaoVazia(x, y)) {
					caminharMatrizPesquisa(x,y);
				}
			}
		}
	}
	
	/**
	 * M�todo caminharMatrizPesquisa.
	 * @param xOriginal
	 * @param yOriginal
	 */
	private void caminharMatrizPesquisa(int xOriginal, int yOriginal) {
		boolean match = true;
		for(int y = 0; y < getMatrizPesquisa().getQtLinhas(); y++) {
			for(int x = 0; x < getMatrizPesquisa().getQtColunas(); x++) {
				match = match(xOriginal, yOriginal, x, y);
				if(!match) {
					break;
				}
			}
			if(!match) {
				break;
			}
		}
		if (match) {
			getMatrizIndice().setPosicao(xOriginal, yOriginal, INDEX_MATCH);
		}
	}
	
	/**
	 * M�todo match.
	 * @param xOriginal
	 * @param yOriginal
	 * @param xPesquisa
	 * @param yPesquisa
	 * @return boolean
	 */
	private boolean match(int xOriginal, int yOriginal, int xPesquisa, int yPesquisa) {
		boolean match = true;
		if (!getMatrizOriginal().isPosicaoValida(
				xOriginal + getMatrizPesquisa().getQtColunas() - 1,
				yOriginal + getMatrizPesquisa().getQtLinhas() - 1) ) {
			getMatrizIndice().setPosicao(xOriginal, yOriginal, INDEX_FAIL);
			match = false;
		} else {
			if (!getMatrizPesquisa().getPosicaoInicial().equals(
					getMatrizOriginal().getPosicao(xOriginal + xPesquisa, yOriginal + yPesquisa))) {
				getMatrizIndice().setPosicao(xOriginal + xPesquisa, yOriginal + yPesquisa, INDEX_FAIL);
			} else {
				getMatrizIndice().setPosicao(xOriginal + xPesquisa, yOriginal + yPesquisa, INDEX_POTENCIAL);
			}

			if(!getMatrizPesquisa().getPosicao(xPesquisa, yPesquisa).equals(
					getMatrizOriginal().getPosicao(xOriginal + xPesquisa, yOriginal + yPesquisa))) {
				getMatrizIndice().setPosicao(xOriginal, yOriginal, INDEX_FAIL);
				match = false;
			}
		}
		return match;
	}
	
	/**
	 * M�todo mostrarResultado.
	 */
	private void mostrarResultado() {
		getMatrizOriginal().printMatriz();
		getMatrizPesquisa().printMatriz();
		getMatrizIndice().printMatriz();
		getMatrizResultado().printMatriz();
	}

	/**
	 * M�todo getMatrizOriginal.
	 * @return Matriz
	 */
	public Matriz getMatrizOriginal() {
		return matrizOriginal;
	}

	/**
	 * M�todo setMatrizOriginal.
	 * @param matrizOriginal
	 */
	public void setMatrizOriginal(Matriz matrizOriginal) {
		this.matrizOriginal = matrizOriginal;
	}

	/**
	 * M�todo getMatrizPesquisa.
	 * @return Matriz
	 */
	public Matriz getMatrizPesquisa() {
		return matrizPesquisa;
	}

	/**
	 * M�todo setMatrizPesquisa.
	 * @param matrizPesquisa
	 */
	public void setMatrizPesquisa(Matriz matrizPesquisa) {
		this.matrizPesquisa = matrizPesquisa;
	}

	/**
	 * M�todo getMatrizIndice.
	 * @return Matriz
	 */
	public Matriz getMatrizIndice() {
		return matrizIndice;
	}

	/**
	 * M�todo setMatrizIndice.
	 * @param matrizIndice
	 */
	private void setMatrizIndice(Matriz matrizIndice) {
		this.matrizIndice = matrizIndice;
	}

	/**
	 * M�todo getMatrizResultado.
	 * @return Matriz
	 */
	public Matriz getMatrizResultado() {
		return matrizResultado;
	}

	/**
	 * M�todo setMatrizResultado.
	 * @param matrizResultado
	 */
	private void setMatrizResultado(Matriz matrizResultado) {
		this.matrizResultado = matrizResultado;
	}
	
}
