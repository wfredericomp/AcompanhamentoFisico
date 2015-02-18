package br.com.view;

import javax.swing.JOptionPane;

import br.com.modelo.Usuario;
import br.com.util.Arquivo;
import br.com.util.Validador;

public class UsuarioView {
	Validador validar = new Validador();

	public String lerNome() {

		try {
			String nome = JOptionPane
					.showInputDialog("Informe seu nome entre 5 e 45 caracteres: ");
			if (nome == null) {
				System.exit(1);
			}
			if (!validar.validarNome(nome)) {
				JOptionPane.showMessageDialog(null,
						"O nome precisa ter entre 5 e 45 caracteres.");
				return lerNome();
			}
			return nome;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"O nome precisa ter entre 5 e 45 caracteres.");
			return lerNome();
		}
	}

	public String lerIdade() {
		try {
			String idade = JOptionPane
					.showInputDialog("Informe sua idade entre 16 e 99 anos: ");
			if (idade == null) {
				System.exit(1);
			}
			if (!validar.validarIdade(idade)) {
				JOptionPane.showMessageDialog(null,
						"A idade precisa ser entre 16 anos e 99 anos.");
				return lerIdade();
			}
			return idade;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"A idade precisa ser entre 16 anos e 99 anos.");
			return lerIdade();
		}
	}

	public String lerAltura() {
		try {
			String altura = JOptionPane
					.showInputDialog("Informe sua altura entre 1.40 e 2.20 m: ");
			if (altura == null) {
				System.exit(1);
			}
			if (!validar.validarAltura(altura)) {
				JOptionPane.showMessageDialog(null,
						"A altura deve ser entre 1.40 e 2.20 m. ");
				return lerAltura();
			}
			return altura;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"A altura deve ser entre 1.40 e 2.20 m. ");
			return lerAltura();
		}
	}

	public String lerPeso() {
		try {
			String peso = JOptionPane
					.showInputDialog("Informe seu peso entre 40kg e 120kg: ");
			if (peso == null) {
				System.exit(1);
			}
			if (!validar.validarPeso(peso)) {
				JOptionPane.showMessageDialog(null,
						"O peso deve ser entre 40kg e 120kg.");
				return lerPeso();
			}
			return peso;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"O peso deve ser entre 40kg e 120kg.");
			return lerPeso();
		}
	}

	public void imprimirDadosUsuario(Usuario u) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n#### #### #### #### #### #### ####");
		sb.append("\nNome: " + u.getNome());
		sb.append("\nIdade: " + u.getIdade() + " anos.");
		sb.append("\nAltura: " + u.getAltura() + " m.");
		sb.append("\nPeso: " + u.getPeso() + " kg.");
		sb.append("\n#### #### #### #### #### #### ####");

		Arquivo cria = new Arquivo();
		cria.gravaSaida(sb.toString());
		
		System.out.println(sb.toString());
		JOptionPane.showMessageDialog(null, sb.toString());
	}

}
