package br.com.alura.model;

public class Produto {

	private Double preco;
	private String nome;

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nPreço: " + preco + "\n";
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
