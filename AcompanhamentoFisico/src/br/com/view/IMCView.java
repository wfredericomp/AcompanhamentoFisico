package br.com.view;

import javax.swing.JOptionPane;

import br.com.modelo.IMC;
import br.com.util.Arquivo;
import br.com.util.CalculoIMC;

public class IMCView {
	IMC imc = new IMC();
	CalculoIMC calc = new CalculoIMC();

	static String[] caloriasSemanaIngeridas = new String[7];
	static String[] caloriasSemanaUtilizadas = new String[7];
	static String[] caloriasSemanaIngeridasTotal = new String[7];
	static int cont1 = 0;
	static int cont2 = 0;

	public static void alimentaVetorCalorias(String[] cal){
		int cont = 0;
		for(String a : cal){
			caloriasSemanaIngeridasTotal[cont] = a;
			cont++;
		}
	}
	
	public void imprimeIMCAtual(IMC imc) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n### IMC atual ###");
		sb.append("\nPeso: " + imc.getPeso());
		sb.append("\nAltura: " + imc.getAltura());
		sb.append("\nIMC atual: " + imc.getImc());
		sb.append("\nPeso ganho: " + imc.getGanho()+ " kg.  ");
		sb.append("\nVocê encontra-se " + calc.tabelaIMC(imc.getImc()));
		sb.append("\n### ### ### ### ###");
		caloriasSemanaIngeridas[cont1] = imc.getGanho().toString();
		cont1++;
		
		Arquivo cria = new Arquivo();
		cria.gravaSaida(sb.toString());
		
		System.out.println(sb.toString());
		JOptionPane.showMessageDialog(null, sb.toString());
	}

	public void imprimeIMCAtualUtilizada(IMC imc) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n### IMC atual Utilizado###");
		sb.append("\nPeso: " + imc.getPeso());
		sb.append("\nAltura: " + imc.getAltura());
		sb.append("\nIMC atual: " + imc.getImc());
		sb.append("\nPeso perdido: " + imc.getPerda()+ " kg.  ");
		sb.append("\nVocê encontra-se " + calc.tabelaIMC(imc.getImc()));
		sb.append("\n### ### ### ### ###");
		caloriasSemanaUtilizadas[cont2] = imc.getPerda().toString();
		cont2++;

		Arquivo cria = new Arquivo();
		cria.gravaSaida(sb.toString());
		
		System.out.println(sb.toString());
		JOptionPane.showMessageDialog(null, sb.toString());
	}

	public void imprimeIMCEstimado(Double estimado) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n###    IMC Estimado    ###");
		sb.append("\nO IMC estimado de uma semana é: " + estimado + " .");
		sb.append("\nO IMC estimado de uma semana é: " + estimado + " .");
		sb.append("\nVocê encontra-se " + calc.tabelaIMC(estimado));
		sb.append("\nVocê ingeriu "
				+ CalculoIMC.caloriasSemanaIngeridas(caloriasSemanaIngeridas)
				+ " calorias em uma semana.");
		sb.append("\nVocê ganhou "
				+ CalculoIMC.kgSemanaIngeridas(caloriasSemanaIngeridas)
				+ " kg em uma semana.");
		sb.append("\n###   ###   ###   ###   ###");

		Arquivo cria = new Arquivo();
		cria.gravaSaida(sb.toString());
		
		System.out.println(sb.toString());
		JOptionPane.showMessageDialog(null, sb.toString());
	}
	
	public void imprimeIMCEstimadoFinal() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n###    IMC Estimado    ###");
		sb.append("\nVocê ingeriu "
				+ CalculoIMC.caloriasSemanaIngeridas(caloriasSemanaIngeridasTotal)
				+ " calorias em uma semana.");
		sb.append("\nVocê ganhou "
				+ CalculoIMC.kgSemanaIngeridas(caloriasSemanaIngeridas)
				+ " kg em uma semana.");
		sb.append("\n###   ###   ###   ###   ###");

		Arquivo cria = new Arquivo();
		cria.gravaSaida(sb.toString());
		
		System.out.println(sb.toString());
		JOptionPane.showMessageDialog(null, sb.toString());
	}
}
