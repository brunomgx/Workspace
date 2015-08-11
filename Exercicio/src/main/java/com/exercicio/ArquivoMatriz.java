package com.exercicio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Bruno C. S. Feliciano
 *
 */
public class ArquivoMatriz {

	/**
	 * Controle de Log.
	 */
	private static final Logger log = Logger.getLogger(ArquivoMatriz.class.getName());
	
	// ATRIBUTOS DE CONTROLE
	private final String HEADER_MATRIZ = "[Matriz_original]";
	private final String HEADER_PESQUISA = "[Matriz_pesquisa]";
	
	// ATRIBUTOS DO ARQUIVO
	private List<String> linhasMatriz;
	private List<String> linhasPesquisa;
	
	/**
	 * M�todo leituraArquivo.
	 * @param diretorio
	 * @param nomeArquivo
	 * @return boolean
	 */
	public boolean leituraArquivo(String nomeArquivo) {
		try {
			FileReader arquivo;
			arquivo = new FileReader(nomeArquivo);
			if (arquivo.ready()) {
				log.info("O arquivo est� no formato adequado.");
			} else {
				log.warning("O arquivo n�o est� no formato adequado.");
			}
			return leituraArquivo(arquivo);
		} catch (FileNotFoundException e) {
			log.severe("O arquivo n�o foi encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("N�o foi possivel fazer a leitura do arquivo.");
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * M�todo leituraArquivo.
	 * @param diretorio
	 * @param nomeArquivo
	 * @return boolean
	 */
	public boolean leituraArquivo(String diretorio, String nomeArquivo) {
		try {
			FileReader arquivo;
			arquivo = new FileReader(diretorio + "//" + nomeArquivo);
			if (arquivo.ready()) {
				log.info("O arquivo est� no formato adequado.");
			} else {
				log.warning("O arquivo n�o est� no formato adequado.");
			}
			return leituraArquivo(arquivo);
		} catch (FileNotFoundException e) {
			log.severe("O arquivo n�o foi encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("N�o foi possivel fazer a leitura do arquivo.");
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * M�todo leituraArquivo.
	 * @param arquivo
	 * @return boolean
	 */
	public boolean leituraArquivo(FileReader arquivo) {
		boolean original = true;
		Scanner scanner = new Scanner(arquivo);
		setLinhasMatriz(new ArrayList<String>());
		setLinhasPesquisa(new ArrayList<String>());

		while(scanner.hasNext()) {
			String linha = scanner.next();
			if (original) {
				if (HEADER_PESQUISA.equals(linha)) {
					original = false;
				} else {
					if (!HEADER_MATRIZ.equals(linha)) {
						getLinhasMatriz().add(linha);
					}
				}
			} else {
				if (!HEADER_PESQUISA.equals(linha) && !HEADER_MATRIZ.equals(linha)) {
					getLinhasPesquisa().add(linha);
				}
			}
		}
		scanner.close();
		return true;
	}
	
	/**
	 * M�todo gerarMatriz.
	 * @param linhas
	 * @return Matriz
	 */
	private Matriz gerarMatriz(List<String> linhas) {
		Matriz matriz = null;
		int qtlinhas = linhas.size();
		int qtColunas = 0;
		for (int y = 0; y < qtlinhas; y++) {
			String[] colunas = linhas.get(y).split("");
			
			if (y == 0) {
				qtColunas = colunas.length;
				matriz = new Matriz(qtColunas - 1, qtlinhas);
			} else if (qtColunas != colunas.length) {
				log.severe("Matriz do arquivo est� com dimens�es erradas.");
				return null;
			}
			
			for (int x = 1; x < qtColunas; x++) {
				matriz.setPosicao(x-1, y, colunas[x]);
			}
		}
		return matriz;
	}
	
	/**
	 * M�todo gerarMatrizOriginal.
	 * @return Matriz
	 */
	public Matriz gerarMatrizOriginal() {
		if (getLinhasMatriz() != null && !getLinhasMatriz().isEmpty()) {
			return gerarMatriz(getLinhasMatriz());
		} else {
			return null;
		}
	}
	
	/**
	 * M�todo gerarMatrizPesquisa.
	 * @return Matriz
	 */
	public Matriz gerarMatrizPesquisa() {
		if (getLinhasPesquisa() != null && !getLinhasPesquisa().isEmpty()) {
			return gerarMatriz(getLinhasPesquisa());
		} else {
			return null;
		}
	}

	/**
	 * M�todo getLinhasMatriz.
	 * @return List - String
	 */
	public List<String> getLinhasMatriz() {
		return linhasMatriz;
	}

	/**
	 * M�todo setLinhasMatriz.
	 * @param linhasMatriz
	 */
	private void setLinhasMatriz(List<String> linhasMatriz) {
		this.linhasMatriz = linhasMatriz;
	}

	/**
	 * M�todo getLinhasPesquisa.
	 * @return List - String
	 */
	public List<String> getLinhasPesquisa() {
		return linhasPesquisa;
	}

	/**
	 * M�todo setLinhasPesquisa.
	 * @param linhasPesquisa
	 */
	private void setLinhasPesquisa(List<String> linhasPesquisa) {
		this.linhasPesquisa = linhasPesquisa;
	}

}
