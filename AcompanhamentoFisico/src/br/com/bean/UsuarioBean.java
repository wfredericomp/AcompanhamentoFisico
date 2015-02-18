package br.com.bean;

import javax.swing.JOptionPane;

import br.com.modelo.Usuario;
import br.com.util.Semana;
import br.com.view.CaloriasView;
import br.com.view.IMCView;
import br.com.view.UsuarioView;

public class UsuarioBean {
	static String[] caloriasSemanaIngeridas = new String[7];
	static String[] caloriasSemanaUtilizadas = new String[7];
	CaloriasView ca = new CaloriasView();
	static Usuario usuario;

	public void caloriaIngerida() {
		// #### #### Dados de impressão do usuário #### ####
		System.out.println("##### [ CALORIAS INGERIDAS ] #####");
		String[] caloriasSemanaAux = new String[7];
		UsuarioView v = new UsuarioView();
		String nome = v.lerNome();
		String idade = v.lerIdade();
		String altura = v.lerAltura();
		String peso = v.lerPeso();
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setIdade(new Integer(idade));
		user.setAltura(new Double(altura));
		user.setPeso(new Double(peso));
		usuario = user;
		v.imprimirDadosUsuario(user);
		// #### #### #### #### #### #### #### #### #### ####

		// #### #### #### #### #### #### #### #### #### ####
		CaloriasView c = new CaloriasView();
		String[] caloriasSemana = c.lerCaloriasSemana(user);
		caloriasSemanaIngeridas = caloriasSemana;
		IMCView.alimentaVetorCalorias(caloriasSemanaIngeridas);
		int cont = 0;
		for (Semana dia : Semana.values()) {
			caloriasSemanaAux[cont] = dia.toString();
			cont++;
		}

		ca.imprimirCaloriasDia(caloriasSemanaAux, caloriasSemana);
		System.out.println("##### ##### ##### ##### ##### #####\n");
		// #### #### #### #### #### #### #### #### #### ####
	}

	public void caloriaUtilizada() {
		System.out.println("##### [ CALORIAS UTILIZADAS ] #####");
		JOptionPane.showMessageDialog(null,
				"Agora Digite as calorias utilizadas a cada dia da semana.");
		String[] caloriasSemanaAux = new String[7];

		CaloriasView c = new CaloriasView();
		String[] caloriasSemana = c.lerCaloriasSemanaUtilizada(usuario,
				caloriasSemanaIngeridas, caloriasSemanaUtilizadas);
		caloriasSemanaUtilizadas = caloriasSemana;
		int cont = 0;
		for (Semana dia : Semana.values()) {
			caloriasSemanaAux[cont] = dia.toString();
			cont++;
		}
		ca.imprimirCaloriasDia(caloriasSemanaAux, caloriasSemana);
		System.out.println("##### ##### ##### ##### ##### #####\n");
	}

	public void imprimeIMCSemana() {
		IMCView imc = new IMCView();
		imc.imprimeIMCEstimadoFinal();
	}

}
