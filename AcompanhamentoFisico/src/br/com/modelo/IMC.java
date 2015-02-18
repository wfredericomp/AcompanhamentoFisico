package br.com.modelo;

public class IMC {
	private Double peso;
	private Double altura;
	private Double imc;
	private Double perda;
	private Double ganho;

	/**
	 * @param altura
	 * @param imc
	 */
	public IMC() {
		super();
	}

	/**
	 * @param peso
	 * @param altura
	 * @param imc
	 * @param perda
	 * @param ganho
	 */
	public IMC(Double peso, Double altura, Double imc, Double perda,
			Double ganho) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
		this.perda = perda;
		this.ganho = ganho;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Double getPerda() {
		return perda;
	}

	public void setPerda(Double perda) {
		this.perda = perda;
	}

	public Double getGanho() {
		return ganho;
	}

	public void setGanho(Double ganho) {
		this.ganho = ganho;
	}

}
