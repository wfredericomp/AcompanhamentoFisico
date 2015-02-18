package br.com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Arquivo {
	
	BufferedWriter outArq = null;
	BufferedReader inArq = null;
	String inputFileNameLocal, outputFileNameLocal;
	static FileOutputStream fos;

	public void setOutputFileNameLocal(String outputFileNameLocal) {
		this.outputFileNameLocal = outputFileNameLocal;
	}

	public void abreSaida() {
		try {
			fos = new FileOutputStream(outputFileNameLocal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gravaSaida(String linha) {
		try {
			fos.write(linha.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fechaEntrada() {
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
