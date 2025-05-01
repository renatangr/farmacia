package farmacia.model;

public class Medicamento extends Produto {
	
	// Atributo do Medicamento
	private String generico;

	// Método construtor de Medicamento
	public Medicamento(int id, String nome, int tipo, float preco, String generico) {
		super(id, nome, tipo, preco);
		this.generico = generico;
	}

	// Getters and Setters
	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("GENÉRICO: " + this.generico);
		System.out.println("─────────────────────────────────────");

	}

}
