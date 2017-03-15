package br.com.rodrigo.buscatextual.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nomeAutor) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nomeAutor;
		
	}
	
	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(this.nomeArquivo));
			
			int numeroLinha = 1;
			
			while(scanner.hasNextLine()){
				
				String linha = scanner.nextLine();
				
				if(linha.toLowerCase().contains(nome.toLowerCase())){
					System.out.println(nomeArquivo + "  " +  numeroLinha + " - " + linha);
				}
				
				numeroLinha++;
				
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
