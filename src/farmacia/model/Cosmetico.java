package farmacia.model;

public class Cosmetico extends Produto {
	
	private String fragrancia;

	public Cosmetico(int id, String nome, int tipo, float preco, String fragancia) {
		super(id, nome, tipo, preco);
		this.fragrancia = fragancia;
	}

	public String getFragancia() {
		return fragrancia;
	}

	public void setFragancia(String fragancia) {
		this.fragrancia = fragancia;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(" FRAGRÂNCIA: " + this.fragrancia);
		System.out.println("─────────────────────────────────────");
		
	}
	
	

}
