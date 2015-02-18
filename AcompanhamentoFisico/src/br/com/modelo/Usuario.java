package br.com.modelo;

public class Usuario {
	private String nome;
	private Integer idade;
	private Double altura;
	private Double peso;
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	
	
	/**
	 * @param nome
	 * @param idade
	 * @param altura
	 * @param peso
	 */
	public Usuario(String nome, Integer idade, Double altura, Double peso) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
	
}
