package br.com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

	public boolean validarIdade(String idade) {
		Pattern p1 = Pattern.compile("[0-9]{1,2}");
		Matcher m1 = p1.matcher(idade);
		if (!m1.matches()) {
			return false;
		}
		int newCod = new Integer(idade);
		if (newCod < 16) {
			return false;
		}
		if (newCod > 99) {
			return false;
		}
		return true;
	}

	public boolean validarNome(String nome) {
		Pattern p1 = Pattern.compile("[a-zA-Z á-ú]{5,45}");
		Matcher m1 = p1.matcher(nome);
		return m1.matches();
	}

	public boolean validarAltura(String altura) {
		Pattern p1 = Pattern.compile("\\d{1,3}(,\\d{3})*(\\.\\d{2})?");
		Matcher m1 = p1.matcher(altura);
		Double newAltura = new Double(altura);
		if (!m1.matches()) {
			return false;
		}
		if (newAltura < 1.40) {
			return false;
		}
		if (newAltura > 2.20) {
			return false;
		}
		return true;
	}

	public boolean validarPeso(String peso) {
		Pattern p1 = Pattern.compile("[0-9]{2,3}");
		Matcher m1 = p1.matcher(peso);
		if (!m1.matches()) {
			return false;
		}
		Integer newPeso = new Integer(peso);
		if (newPeso < 40) {
			return false;
		}
		if (newPeso > 120) {
			return false;
		}
		return true;
	}
}
