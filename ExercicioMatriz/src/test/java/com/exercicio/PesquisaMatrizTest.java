package com.exercicio;

import static org.junit.Assert.*;

import org.junit.Test;

public class PesquisaMatrizTest {

	@Test
	public void test() {
		String nomeArquivo = "configuracao.txt";
		String diretorio = "C://Bruno//Estudo//desafio//Visual//Teste//Quest�o 1";
		
		PesquisaMatriz pesquisaMatriz = new PesquisaMatriz();
		
		assertTrue(pesquisaMatriz.pesquisarMatriz(diretorio, nomeArquivo));
	}

}
