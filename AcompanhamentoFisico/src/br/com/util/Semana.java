package br.com.util;

public enum Semana {
	DOMINGO(1), SEGUNDA(2), TERÇA(3), QUARTA(4), QUINTA(5), SEXTA(6), SABADO(7);
	
private int value;
	
	private Semana(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
