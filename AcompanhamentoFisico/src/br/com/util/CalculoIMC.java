package br.com.util;

import java.util.ArrayList;

import br.com.modelo.IMC;

public class CalculoIMC {
	IMC i = new IMC();
	static ArrayList<IMC> imcList = new ArrayList<IMC>();

	public IMC imcAtual(Double peso, Double altura) {
		Double imc;
		imc = (peso) / (altura * altura);
		i.setPeso(peso);
		i.setAltura(altura);
		i.setImc(imc);
		imcList.add(i);
		return i;
	}

	public String tabelaIMC(Double imc) {
		String strimc = null;
		if (imc < 18.5) {
			return strimc = "Subnutrido";
		}
		if (imc > 18.5 && imc < 24.9) {
			return strimc = "Peso saudável";
		}
		if (imc > 24.9 && imc < 29.9) {
			return strimc = "Sobrepeso";
		}
		if (imc > 29.9 && imc < 34.9) {
			return strimc = "Obesidade Grau I";
		}
		if (imc > 34.9 && imc < 39.9) {
			return strimc = "Obesidade Grau II";
		}
		if (imc > 39.9) {
			return strimc = "Obesidade Grau III";
		}
		return strimc;
	}

	public Double recalcularCalorias(Double peso, Double calorias, IMC imcV,
			Double altura) {
		Double kg = 0.;
		Double media = calorias / 7700.00;
		kg = new Double(peso + media);
		Double imc = (kg) / (altura * altura);
		imcV.setGanho(media);
		imcV.setPeso(kg);
		imcV.setImc(imc);
		return kg;
	}

	public Double recalcularCaloriasUtilizadas(Double peso, Double calorias,
			IMC imcV, Double altura, String[] caloriasSemanaIngeridas,
			String[] caloriasSemanaUtilizadas, int cont) {
		Double kg = peso;

		String aux1 = caloriasSemanaIngeridas[cont].toString();
		String aux2 = caloriasSemanaUtilizadas[cont].toString();
		if(Double.valueOf(aux2) > Double.valueOf(aux1)){
			String aux;
			aux = aux1;
			aux1 = aux2;
			aux2 = aux;
		}
		Double media = Double.valueOf(aux1) - Double.valueOf(aux2);
		media = media / 7700.00;
		kg = new Double(kg - media);
		Double imc = (kg) / (altura * altura);
		imcV.setPerda(media);
		imcV.setPeso(kg);
		imcV.setImc(imc);
		return kg;
	}

	public static String caloriasSemanaIngeridas(
			String[] caloriasSemanaIngeridas) {
		String calorias = "";
		Double soma = 0.;
		Double media = 0.;
		for (String cal : caloriasSemanaIngeridas) {
			soma = Double.valueOf(cal);
			media = media + soma;
		}
		calorias = media.toString();
		return calorias;
	}

	public static String kgSemanaIngeridas(String[] caloriasSemanaIngeridas) {
		String pesoGanho = "";
		Double soma = 0.;
		Double media = 0.;
		for (String cal : caloriasSemanaIngeridas) {
			soma = Double.valueOf(cal);
			media = media + soma;
		}
		media = (media / 7700.00);
		pesoGanho = media.toString();
		return pesoGanho;
	}

}
