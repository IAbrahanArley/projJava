package entities;

public class Acao extends Ativo{
	private String type;
	
	public Acao() {
		
	}
	
	public Acao(String name, String cod, Double price, Integer quant, String type) {
		super(name, cod, price, quant);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
