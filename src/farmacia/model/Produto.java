package farmacia.model;

import java.text.NumberFormat;

public abstract class Produto {
	
	// Atributos da classe produto
	private int id;
	private String nome;
	private int tipo;
	private float preco;
	
	// Método construtor
	public Produto(int id, String nome, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	// Método visualizar
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> tipo = "Medicamento";
		case 2 -> tipo = "Cosmético";
		}
		
		System.out.println("ID: " + this.id);
		System.out.println("NOME: " + this.nome);
		System.out.println("PREÇO: " + nfMoeda.format(this.preco));
		System.out.println("TIPO: " + tipo);

	};
	

}
