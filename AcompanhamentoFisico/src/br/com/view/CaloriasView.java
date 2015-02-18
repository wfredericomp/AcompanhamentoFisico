package br.com.view;

import javax.swing.JOptionPane;

import br.com.modelo.IMC;
import br.com.modelo.Usuario;
import br.com.util.Arquivo;
import br.com.util.CalculoIMC;
import br.com.util.Semana;

public class CaloriasView {

	public String[] lerCaloriasSemana(Usuario u) {
		String[] caloriasDias = new String[7];
		for (int i = 0; i < 7; i++) {
			caloriasDias[i] = "0";
		}
		int cont = 0;
		String caloriasDia = "";
		ForaFor: for (Semana dia : Semana.values()) {
			Fora: do {
				Boolean digitouCerto = false;
				ForaDia: do {
					caloriasDia = JOptionPane
							.showInputDialog("Digite a caloria ingerida no dia "
									+ dia.toString() + ": entre 10 e 15000 ");
					try {
						if (caloriasDia == null) {
							System.exit(1);
						}
						if (caloriasDia.equals("0"))
							break ForaFor;
						Integer newCal = new Integer(caloriasDia);
						if (newCal < 10) {
							JOptionPane
									.showMessageDialog(null,
											"Por favor digite a caloria ingerida no dia: entre 10 e 15000 ");
							break ForaDia;
						}
						if (newCal > 15000) {
							JOptionPane
									.showMessageDialog(null,
											"Por favor digite a caloria ingerida no dia: entre 10 e 15000 ");
							break ForaDia;
						}
						digitouCerto = true;
					} catch (Exception e) {
						JOptionPane
								.showMessageDialog(
										null,
										"Por favor digite do tipo numerica a caloria ingerida no dia: entre 10 e 15000 ");
						break ForaDia;
					}
					caloriasDias[cont] = caloriasDia;
					CalculoIMC imc = new CalculoIMC();
					IMC imcV = new IMC();
					imcV = imc.imcAtual(u.getPeso(), u.getAltura());
					imc.recalcularCalorias(u.getPeso(),
							new Double(caloriasDia), imcV, u.getAltura());
					u.setPeso(imcV.getPeso());
					IMCView view = new IMCView();
					view.imprimeIMCAtual(imcV);

					cont++;
					if (!caloriasDia.equals("0"))
						break Fora;
				} while (!digitouCerto);

				if (caloriasDia.equals("0"))
					break ForaFor;
			} while (!caloriasDia.equals("0"));

		}
		return caloriasDias;
	}
	
	public String[] lerCaloriasSemanaUtilizada(Usuario u,
			String[] caloriasSemanaIngeridas, String[] caloriasSemanaUtilizadas) {
		String[] caloriasDias = new String[7];
		for (int i = 0; i < 7; i++) {
			caloriasDias[i] = "0";
		}
		int cont = 0;
		String caloriasDia = "";
		ForaFor: for (Semana dia : Semana.values()) {
			Fora: do {
				Boolean digitouCerto = false;
				ForaDia: do {
					caloriasDia = JOptionPane
							.showInputDialog("Digite a caloria utilizada no dia "
									+ dia.toString() + ": entre 10 e 15000 ");
					try {
						if (caloriasDia == null) {
							System.exit(1);
						}
						if (caloriasDia.equals("0"))
							break ForaFor;
						Integer newCal = new Integer(caloriasDia);
						if (newCal < 10) {
							JOptionPane
									.showMessageDialog(null,
											"Por favor digite a caloria utilizada no dia: entre 10 e 15000 ");
							break ForaDia;
						}
						if (newCal > 15000) {
							JOptionPane
									.showMessageDialog(null,
											"Por favor digite a caloria utilizada no dia: entre 10 e 15000 ");
							break ForaDia;
						}
						digitouCerto = true;
					} catch (Exception e) {
						JOptionPane
								.showMessageDialog(
										null,
										"Por favor digite do tipo numerica a caloria utilizada no dia: entre 10 e 15000 ");
						break ForaDia;
					}
					caloriasDias[cont] = caloriasDia;
					caloriasSemanaUtilizadas[cont] = caloriasDia;
					CalculoIMC imc = new CalculoIMC();
					IMC imcV = new IMC();
					imcV = imc.imcAtual(u.getPeso(), u.getAltura());
					imc.recalcularCaloriasUtilizadas(u.getPeso(),
							new Double(caloriasDia), imcV, u.getAltura(), caloriasSemanaIngeridas, caloriasSemanaUtilizadas, cont);
					u.setPeso(imcV.getPeso());
					IMCView view = new IMCView();
					view.imprimeIMCAtualUtilizada(imcV);

					cont++;
					if (!caloriasDia.equals("0"))
						break Fora;
				} while (!digitouCerto);

				if (caloriasDia.equals("0"))
					break ForaFor;
			} while (!caloriasDia.equals("0"));

		}
		return caloriasDias;
	}

	public void imprimirCaloriasDia(String[] caloriasSemanaAux,
			String[] caloriasSemana) {
		int cont = 0;
		for (String cal : caloriasSemana) {
			String linha = "Calorias do dia: " + caloriasSemanaAux[cont]
					+ " : " + cal + " ";
			System.out.println("Calorias do dia: " + caloriasSemanaAux[cont]
					+ " : " + cal + " ");
			cont++;
			

			Arquivo cria = new Arquivo();
			cria.gravaSaida(linha);
			
		}
	}
}
