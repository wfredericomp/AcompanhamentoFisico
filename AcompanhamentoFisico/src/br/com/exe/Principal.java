package br.com.exe;

import javax.swing.JOptionPane;

import br.com.bean.UsuarioBean;
import br.com.util.Arquivo;

public class Principal {
	public static void main(String[] args) {
		Arquivo cria = new Arquivo();
		cria.setOutputFileNameLocal("CalculoIMC-1.0.doc");
		cria.abreSaida();
		
		UsuarioBean p = new UsuarioBean();
		JOptionPane.showMessageDialog(null, "### Seja bem vindo ao sistema de Calculo de calorias IMC ###");
		p.caloriaIngerida();
		p.caloriaUtilizada();
		p.imprimeIMCSemana();
		//git
		cria.fechaEntrada();
	}
}
